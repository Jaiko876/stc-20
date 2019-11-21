package ru.stc20.molostvov.lesson05;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Алексей","М");
        Person person2 = new Person("Анатолий","М");
        Person person3 = new Person("Виталий","М");
        Person person4 = new Person("Анна","Ж");
        Person person5 = new Person("Евгения","Ж");
        Person person6 = new Person("Виталяй","М");

        Animal animal1 = new Animal("Барсик", person1,5);
        Animal animal2 = new Animal("Снежок", person4,25);
        Animal animal3 = new Animal("Волчара", person2,47);
        Animal animal4 = new Animal("Пушистик", person2,1);
        Animal animal5 = new Animal("Оскар", person3,32);
        Animal animal6 = new Animal("Оскар", person5,33);
        Animal animal7 = new Animal("Виталий", person6,87);
        Animal animal8 = new Animal("Андрэ", person6,17);
        Animal animal9 = new Animal("Улюлян", person5,82);
        Animal animal10 = new Animal("Мурзик", person3,42);
        Animal animal11 = new Animal("Кирпич", person1,24);
        Animal animal12 = new Animal("Виталий", person3,8247);
        Animal animal13 = new Animal("Виталий", person1,84);

        AnimalCollection animalCollection = new AnimalCollection();

        animalCollection.addAnimal(animal2);
        animalCollection.addAnimal(animal3);
        animalCollection.addAnimal(animal5);
        animalCollection.addAnimal(animal1);
        animalCollection.addAnimal(animal6);
        animalCollection.addAnimal(animal4);
        animalCollection.addAnimal(animal4);
        animalCollection.addAnimal(animal7);
        animalCollection.addAnimal(animal8);
        animalCollection.addAnimal(animal9);
        animalCollection.addAnimal(animal10);
        animalCollection.addAnimal(animal11);
        animalCollection.addAnimal(animal12);
        animalCollection.addAnimal(animal13);

        animalCollection.sortedPrint();
        System.out.println();
        animalCollection.search("Виталий");

        animalCollection.changeName(1, "Крокодил");
        animalCollection.changeWeight(1, 32);
        animalCollection.changeOwner(1, person3);

        System.out.println();
        animalCollection.sortedPrint();
    }
}
