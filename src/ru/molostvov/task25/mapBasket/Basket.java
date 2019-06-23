package ru.molostvov.task25.mapBasket;

import java.util.Map;

interface Basket {

    void addProduct(String product, int quantity);

    void removeProduct(String product);

    void updateProductQuantity(String product, int quantity);

    void clear();

    Map<String, Integer> getProducts();

    int getProductQuantity(String product);

}
