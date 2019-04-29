package ru.molostvov.task6;

import java.util.Arrays;
import java.util.Date;

public class Converter {
    private static void convertion(Contract contract) {
        Act act = new Act();
        act.date = contract.date;
        act.number = contract.number;
        act.products = contract.products;
        System.out.println(act.toString());
    }

    public static void main(String[] args) {
        Contract contract1 = new Contract();
        Contract contract2 = new Contract();
        convertion(contract1);
        convertion(contract2);
    }
}

class Contract {
    private static int counter = 1;
    int number;
    Date date = new Date();
    String [] products = new String[] {"iphone 6", "iphone 5"};
    Contract() {
        counter ++;
        this.number = counter - 1;
    }
}

class Act {
    int number;
    Date date = new Date();
    String [] products = new String[2];

    @Override
    public String toString() {
        return "Act{" +
                "number=" + number +
                ", date=" + date +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}