package ru.molostvov.task15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFiles {
    public static void main(String[] args) {
        try {
            File file = new File("File1.txt");
            Path path = file.toPath();
            Files.createFile(path);
            Files.copy(path, Paths.get("File2.txt"));
            System.out.println(file);
            File renamedFile = new File("RenamedFile.txt");
            boolean b = file.renameTo(renamedFile);
            System.out.println("Переименовываем файл: " + b);
            path = null;
            file = null;
            Files.delete(Paths.get("File2.txt"));
            System.out.println(renamedFile.delete());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
