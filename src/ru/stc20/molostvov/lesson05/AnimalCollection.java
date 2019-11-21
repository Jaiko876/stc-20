package ru.stc20.molostvov.lesson05;

import java.util.*;

/**
 * Коллекция Animal, реализует всю необходимую по заданию логику.
 * @author Игорь Молоствов
 */

public class AnimalCollection {
    private Map<Integer,Animal> animalMap = new HashMap<>();

    /**
     * Метод добавляет новых Animal в коллекцию, при добавлении одинаковых объектов генерирует исключение.
     * @param animal - объект типа Animal
     */
    public void addAnimal(Animal animal) {
        int id = animal.getId();
        if (animalMap.containsKey(id)) {
            try {
                throw new Exception(animal.getName() + " уже есть в коллекции!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        animalMap.put(id,animal);
    }

    /**
     * Метод выводит отсортированную коллекцию в консоль.
     */
    public void sortedPrint() {
        List<Animal> collection = new ArrayList<>();
        for (Map.Entry<Integer,Animal> animalEntry: animalMap.entrySet()) {
            Animal animal = animalEntry.getValue();
            collection.add(animal);
        }
        Collections.sort(collection);
        for (Animal animal: collection) {
            System.out.println(animal);
        }
    }

    /**
     * Метод осуществляет поиск необходимого животного по полю name.
     * @param name - имя Animal
     */
    public void search(String name) {
        List<Animal> collection = new ArrayList<>();
        for (Map.Entry<Integer,Animal> animalEntry: animalMap.entrySet()) {
            Animal animal = animalEntry.getValue();
            collection.add(animal);
        }
        collection.sort(new AnimalByNameComparator());

        /*for (Animal animal : collection) {
            System.out.println(animal);
        }*/

        System.out.println();
        int amount;
        int result = binarySearchIterWrapper(collection, name);
        if (result > 0) {
            amount = checkSameNames(result, collection, name);
            for (int i = result; i <= result + amount; i++) {
                System.out.println(animalMap.get(collection.get(i).getId()));
            }
        } else {
            System.out.println("Животного с именем " + name + " нет в коллекции!");
        }
    }

    /**
     * Бинарный поиск, который всегда возвращает крайний левый эллемент, если совпадений несколько. Возвращает
     * отрицательное число, если искомый эллемента нет в коллекции.
     * @param array - коллекция типа Animal
     * @param descendingOrder - порядок сортировки
     * @param key - искомое значение
     * @return - возвращает число - индекс эллемента или отрицательное значение при неудачном поиске.
     */
    private int binarySearchIter(List<Animal> array, boolean descendingOrder, String key)
    {
        int left = 0;
        int right = array.size();
        int mid = 0;

        while (!(left >= right))
        {
            mid = left + (right - left) / 2;

            if (array.get(left).getName().compareToIgnoreCase(key) == 0) {
                return left;
            }

            if (array.get(mid).getName().compareToIgnoreCase(key) == 0) {
                if (mid == left + 1)
                    return mid;
                else
                    right = mid + 1;
            }

            else if ((array.get(mid).getName().compareToIgnoreCase(key) > 0) ^ descendingOrder)
                right = mid;
            else
                left = mid + 1;
        }

        return -(1 + left);
    }

    /**
     * Абсолютно не нужный в данном случае враппер, но он есть.
     * @param array - коллекция Animal
     * @param key - искомое значение
     * @return - вызывает бинарный поиск
     */
    private int binarySearchIterWrapper(List<Animal> array, String key)
    {
        if (array.size() == 0)
            return -1;

        boolean descendingOrder = array.get(0).getName().compareToIgnoreCase(array.get(array.size() - 1).getName()) > 0;
        return binarySearchIter(array, descendingOrder, key);
    }

    /**
     * Метод проверяет, есть ли еще совпадения с искомым эллементом, кроме одного.
     * @param index - индекс, с которого нужно начать проверку.
     * @param array - коллекция типа Animal
     * @param key - проверяемое значение
     * @return - количество совпадений
     */
    private int checkSameNames(int index, List<Animal> array, String key) {
        int result = 0;
        while (true) {
            if ((array.size() - 1) != index && array.get(++index).getName().compareTo(key) == 0) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public void changeOwner(int id, Person person) {
        animalMap.get(id).setOwner(person);
    }
    public void changeName(int id, String name) {
        animalMap.get(id).setName(name);
    }
    public void changeWeight(int id, int weight) {
        animalMap.get(id).setWeight(weight);
    }
}
