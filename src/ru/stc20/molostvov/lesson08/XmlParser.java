package ru.stc20.molostvov.lesson08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.Field;

/**
 * Класс сериализует/десереализует объект
 * @author Игорь Молоствов
 */
public class XmlParser implements MySerializer {
    private DocumentBuilderFactory dbf;
    private DocumentBuilder builder;
    private Document doc;

    /**
     * Метод сериализует объект
     * @param object - объект
     * @param file - путь к файлу, который будет создан для сериализации
     */
    @Override
    public void serialize(Object object, String file) {
        try {
            dbf = DocumentBuilderFactory.newInstance();
            builder = dbf.newDocumentBuilder();
            doc = builder.newDocument();
            Element element = null;

            addObject(doc, element, object, true);
            writeXmlFile(doc, file);

        } catch (ParserConfigurationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод добавляет элемент в xml файл
     * @param doc - документ
     * @param field - поле
     * @param element - элемент
     * @param object - объект
     * @throws IllegalAccessException - исключение если нет доступа
     */
    private void addElement(Document doc, Field field, Element element, Object object) throws IllegalAccessException {
        field.setAccessible(true);
        Element itemElement = doc.createElement(field.getName());
        Attr attr = doc.createAttribute("type");
        attr.setValue(field.getGenericType().getTypeName());
        itemElement.setAttributeNode(attr);
        itemElement.appendChild(doc.createTextNode(field.get(object).toString()));
        element.appendChild(itemElement);
    }

    /**
     * Так как я писал сперва вариант с объектами, то это обертка должна была работать с объектами, но просто добавляет
     * единственный объект Object, не принадлежащий библиотеке java.lang
     * @param doc - документ
     * @param element - элемент
     * @param object - объект
     * @param first - указатель, что объект корневой
     * @throws IllegalAccessException - исключение если нет доступа
     */
    private void addObject(Document doc, Element element, Object object, boolean first) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        Element itemElement = doc.createElement("Object");
        Attr attr = doc.createAttribute("name");
        attr.setValue(clazz.getName());
        itemElement.setAttributeNode(attr);

        if (first) {
            doc.appendChild(itemElement);
        } else {
            element.appendChild(itemElement);
        }

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().isPrimitive()) {
                addElement(doc, field, itemElement, object);
            }else if (String.class.isAssignableFrom(field.getType())) {
                addElement(doc, field, itemElement, object);
            }
        }
    }

    /**
     * Десериализация в объект
     * @param file - путь к файлу
     * @return - возвращает новый объект
     */
    @Override
    public Object deSerialize(String file) {
        try {
            dbf = DocumentBuilderFactory.newInstance();
            builder = dbf.newDocumentBuilder();
            doc = builder.parse(new File(file));

            doc.getDocumentElement().normalize();
            StringBuilder sb = new StringBuilder();
            Element root = doc.getDocumentElement();
            String name = root.getAttribute("name");
            Class<?> clazz = Class.forName(name);
            Object object = clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();

            NodeList nodeList = root.getChildNodes();
            int fieldNum = 0;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeValue() == null && node.getLastChild() != node) {
                    writeField(node, fields, fieldNum++, object);
                }
            }
        return object;
        } catch (ParserConfigurationException | SAXException | IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Изменение поле нового объекта
     * @param node - нода
     * @param fields - поля объекта
     * @param fieldNum - индекс
     * @param object - объект
     * @throws IllegalAccessException - исключение при ошибке доступа
     */
    private void writeField(Node node, Field[] fields, int fieldNum, Object object) throws IllegalAccessException {
            if (fields[fieldNum].getName().equals(node.getNodeName())) {
                if (node.getAttributes().getNamedItem("type").getNodeValue().equalsIgnoreCase("int")) {
                    fields[fieldNum].setAccessible(true);
                    fields[fieldNum].set(object,Integer.valueOf(node.getTextContent()));
                } else {
                    fields[fieldNum].setAccessible(true);
                    fields[fieldNum].set(object, node.getTextContent());
                }
            }
        }

    /**
     * Запись документа в файл .xml
     * @param xml - документ
     * @param file - путь
     */
    private void writeXmlFile(Document xml, String file) {
        try {
            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            try (BufferedOutputStream osw = new BufferedOutputStream(new FileOutputStream(file))) {
                tf.transform(new DOMSource(xml), new StreamResult(osw));
            } catch (TransformerException | IOException e) {
                e.printStackTrace();
            }
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "src/ru/stc20/molostvov/lesson08/myXml.xml";
        XmlParser xml = new XmlParser();
        xml.serialize(new Person("Vasya",20, "Москва"), path);
        Person person = (Person) xml.deSerialize(path);
        System.out.println(person);
    }
}
