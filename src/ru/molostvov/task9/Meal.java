package ru.molostvov.task9;

public enum Meal {
    CARROT("Морковь",1,true),
    APPLE ("Яблоко",2,false),
    PORRIDGE ("Каша",3,true),
    SHCHI ("Щи",4,false);

    private String name;
    private int index;
    private boolean love;

    Meal(String name, int index, boolean love){
        this.name = name;
        this.index = index;
        this.love = love;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public boolean isLove() {
        return love;
    }
}
