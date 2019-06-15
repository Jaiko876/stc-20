package ru.molostvov.task23;

public class Main {
    public static void main(String[] args) {
        MyBasket myBasket = new MyBasket();
        myBasket.addProduct("Колбаса", 1);
        myBasket.addProduct("Колбаса", 1);
        myBasket.addProduct("Колбаса", 1);
        myBasket.addProduct("Сыр", 2);
        myBasket.addProduct("Молоко", 3);

        System.out.println(myBasket.getProducts());

        System.out.println(myBasket.getProductQuantity("Колбаса"));
        myBasket.updateProductQuantity("Сыр", 5);

        System.out.println(myBasket.getProducts());
        myBasket.updateProductQuantity("Сыр", 1);
        myBasket.removeProduct("Молоко");
        System.out.println(myBasket.getProducts());

        myBasket.clear();

        System.out.println(myBasket.getProducts());
    }
}
