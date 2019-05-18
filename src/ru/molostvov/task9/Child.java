package ru.molostvov.task9;

class Child {

    void Eat(Meal meal) throws MyExeption{
        try {
            if (meal.isLove()) {
                System.out.println("Съел " + meal.getName() + " за обе щеки");
            } else {
                throw new MyExeption();
            }
        } finally {
            System.out.println("Спасибо, мама!");
        }
    }
}
