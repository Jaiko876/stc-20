package ru.molostvov.task21;

import java.util.Arrays;

public class ReverseArr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(Arrays.toString(arr));

        arr = reverse(arr);

        System.out.println(Arrays.toString(arr));


    }
    private static int[] reverse(int[] arr) {
        int counter = arr.length;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            newArr[i] = arr[counter - 1];
            counter--;
        }
        return newArr;
    }
}
