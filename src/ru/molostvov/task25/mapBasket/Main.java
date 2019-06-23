package ru.molostvov.task25.mapBasket;

public class Main {
    public static void main(String[] args) {
        MapBasket mapBasket = new MapBasket();
        System.out.println(mapBasket.getProducts());
        mapBasket.removeProduct("Сыр");
        mapBasket.addProduct("Колбаса", 3);
        mapBasket.removeProduct("Сыр");
        mapBasket.addProduct("Сыр", 2);
        mapBasket.addProduct("Молоко", 12);
        System.out.println(mapBasket.getProducts());
        mapBasket.removeProduct("Сыр");
        System.out.println(mapBasket.getProductQuantity("Колбаса"));
        mapBasket.updateProductQuantity("Молоко", 2);
        System.out.println(mapBasket.getProducts());
        mapBasket.clear();
        System.out.println(mapBasket.getProducts());
    }
}
