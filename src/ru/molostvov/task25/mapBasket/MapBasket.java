package ru.molostvov.task25.mapBasket;

import java.util.HashMap;
import java.util.Map;

public class MapBasket implements Basket {

    private Map <String, Integer> map = new HashMap<>();

    @Override
    public void addProduct(String product, int quantity) {
        map.put(product,quantity);
    }

    @Override
    public void removeProduct(String product) {
        if (map.isEmpty()){
            System.out.println("Корзина пуста!");
            return;
        }
        if (!map.containsKey(product)) {
            System.out.println("Неверный продукт!");
            return;
        }
        map.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        map.replace(product,quantity);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Map<String, Integer> getProducts() {
        return map;
    }

    @Override
    public int getProductQuantity(String product) {
        return map.get(product);
    }
}
