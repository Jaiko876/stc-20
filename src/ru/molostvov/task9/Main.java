package ru.molostvov.task9;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        try {
           // child.Eat(Meal.APPLE);
            child.Eat(Meal.CARROT);
            child.Eat(Meal.SHCHI);
            child.Eat(Meal.PORRIDGE);
        } catch(MyExeption ex){
            System.out.println("Исключение " + ex + " перехвачено!");
        }

        try {
            child.Eat(Meal.PORRIDGE);
            child.Eat(Meal.APPLE);
        } catch(MyExeption ex){
            System.out.println("Исключение " + ex + " перехвачено!");
        }
    }
}
