package ru.molostvov.task15;

import java.io.File;
import java.io.IOException;

public class MyDirs {

    public static void main(String[] args) {
        try {
            File dir = new File("dir");
            dir.mkdir();
            new File("dir/b/a").mkdirs();
            new File("dir/a/f").mkdirs();
            new File("dir/c/e").mkdirs();
            new File("dir/file1.txt").createNewFile();
            new File("dir/file2.txt").createNewFile();
            new File("dir/a/file2.txt").createNewFile();
            new File("dir/a/f/file3.txt").createNewFile();
            new File("dir/b/a/file1.txt").createNewFile();
            new File("dir/b/a/file4.txt").createNewFile();
            new File("dir/c/file4.txt").createNewFile();
            new File("dir/c/e/file423.txt").createNewFile();
            new File("dir/c/file2.txt").createNewFile();
            new File("dir/b/a/file5.txt").createNewFile();

            recursion(dir); //на совести пользователя не вводить необязательный параметр, чтобы ничего не сломать.

            ForRecursion counter = new ForRecursion();

            System.out.println();
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();

            anotherRecursion(dir, counter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void recursion(File dir, String ... strings) {
        File [] files = dir.listFiles();
        String newSpace = "";
        String newSpaceForFiles;

        if (strings.length != 0) {
            for (String anotherVar : strings) {
                newSpace += anotherVar;
            }
        }

        newSpaceForFiles = newSpace + " ";

        if (strings.length == 0) {
            System.out.println(dir.getName());
        }


        if (files != null) {
            for (File file: files) {
                if (file.isDirectory()) {
                    newSpace += " ";
                    System.out.print(newSpace);
                    System.out.println(file);
                    recursion(file, newSpace);
                    newSpace = "";
                } else {
                    System.out.print(newSpaceForFiles);
                    System.out.println(file.getName());
                }
            }
        }
    }

    private static void anotherRecursion (File dir, ForRecursion counter) {
        int thisCounter = counter.getCounter();
        System.out.println("Глубина рекурсии: " + counter.forSout());
        File [] files = dir.listFiles();
        String newSpace = "";
        String newSpaceForFiles;

        if (thisCounter != 0) {
            for (int i = 1; i < thisCounter ; i++) {
                newSpace += " ";
            }
        }

        newSpaceForFiles = newSpace + " ";

        if (thisCounter == 1) {
            System.out.println(dir.getName());
        }


        if (files != null) {
            for (File file: files) {
                if (file.isDirectory()) {
                    newSpace += " ";
                    System.out.print(newSpace);
                    System.out.println(file);
                    anotherRecursion(file,counter);
                    counter.setCounter();
                    newSpace = "";
                } else {
                    System.out.print(newSpaceForFiles);
                    System.out.println(file.getName());
                }
            }
        }
    }
}

class ForRecursion {
    private int counter = 0;

    int forSout() {
        return counter - 1;
    }

    int getCounter() {
        counter++;
        return counter;
    }

    void setCounter() {
        counter--;
    }
}