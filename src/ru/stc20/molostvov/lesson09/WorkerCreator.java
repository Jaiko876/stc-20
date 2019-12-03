package ru.stc20.molostvov.lesson09;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Класс, создающий класс WorkerRealization.
 * @author Игорь Молоствов
 */

public class WorkerCreator {
    private StringBuilder stringBuilder = new StringBuilder();
    /**
     * Метод пишет код будущего класса и позволяет заполнить в ручную метод doWork
     * @return возвращает строку - код класса.
     */
    public String buildCode() {
        Scanner scanner = new Scanner(System.in);
        String scannerString = "smth";
        stringBuilder.append("package ru.stc20.molostvov.lesson09;\n");
        stringBuilder.append("public class WorkerRealization implements Worker {\n");
        stringBuilder.append("    @Override\n");
        stringBuilder.append("public void doWork() {\n");
        while (!scannerString.equalsIgnoreCase("")) {
            scannerString = scanner.nextLine();
            if (!scannerString.equalsIgnoreCase("")) {
                stringBuilder.append(scannerString);
                stringBuilder.append("\n");
            }
        }
        scanner.close();
        stringBuilder.append("\n}");
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }

    /**
     * Метод пишет класс в файл .java
     * @param code - код будущего класса
     * @return - возвращает путь к файлу
     */
    public File writeFile(String code) {
        File path = new File("src/ru/stc20/molostvov/lesson09/WorkerRealization.java");
        try {
            Files.write(path.toPath(), code.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * Класс компилирует и создаёт объект нового класса WorkerRealization
     * @param path - путь к файлу .java
     * @return - возвращает объект нового класса
     */
    public Object compileAndMakeInstance(File path) {
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        int p1;
        p1 = javac.run(null,null,null, path.getPath());
        if (p1 == 0) {
            try {
                MyClassLoader classLoader = new MyClassLoader();
                Class<?> clazz = classLoader.findClass("src/ru/stc20/molostvov/lesson09/WorkerRealization");
                return clazz.newInstance();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
