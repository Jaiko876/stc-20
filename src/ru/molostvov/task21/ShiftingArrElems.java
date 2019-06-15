package ru.molostvov.task21;

public class ShiftingArrElems {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        // Сдвиг эллементов и замещение последнего эллемента 0м

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (j + 1 == arr[i].length) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = arr[i][j + 1];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
