package ru.molostvov.task5;

import java.util.Random;

enum Drinks {
    PEPSI(), COLA(), WATER(), TEA(), FANTA();

    private int cost;
    private int index;
    private String name;

    Drinks() {
        int min = 30;
        int max = 50;
        int diff = max - min;
        Random random = new Random();
        int randCost = random.nextInt(diff + 1);
        randCost += min;

        this.cost = randCost;
        this.name = this.name();
        this.index = this.ordinal() + 1;
    }

    int getCost() {
        return cost;
    }

    int getIndex() {
        return index;
    }

    String getName() {
        return name;
    }
}
