package ru.stc20.molostvov.lesson12;


public class Main {
    public static void main(String[] args) {
        int mult = 1;
        for (int i = 0; i < mult ; i++) {
            new myClass(mult);
            mult *= 2;
        }

    }
}

class myClass {
    private int[][][][] array;
    myClass(int i) {
        array = new int[i][i][i][i];
        for (int j = 0; j < i; j++) {
            array[j][j][j][j] = i*3987;
        }
    }
}