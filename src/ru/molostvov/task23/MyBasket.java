package ru.molostvov.task23;

import java.util.ArrayList;
import java.util.List;

public class MyBasket implements Basket {

    private ArrayList<String> myBasketArrayList = new ArrayList<>();

    @Override
    public void addProduct(String product, int quantity) {
            for (int i = 0; i < quantity ; i++) {
                myBasketArrayList.add(product);
            }
    }

    @Override
    public void removeProduct(String product) {
        myBasketArrayList.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        int counter = getProductQuantity(product);
        if (counter < quantity) {
            while (counter != quantity) {
                myBasketArrayList.add(product);
                counter++;
            }
        } else if (counter > quantity) {
            while (counter != quantity) {
                myBasketArrayList.remove(product);
                counter--;
            }
        }

    }

    @Override
    public void clear() {
        myBasketArrayList.clear();
    }

    @Override
    public List<String> getProducts() {
        return myBasketArrayList;
    }

    @Override
    public int getProductQuantity(String product) {
        int counter = 0;
        for (String s : myBasketArrayList) {
            if (s.contains(product)) {
                counter++;
            }
        }
        return counter;
    }
}
