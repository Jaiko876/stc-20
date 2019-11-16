package ru.stc20.molostvov.lesson05;

import java.util.UUID;

/**
 * Класс описывающий тип Animal
 * @author Игорь Молоствов
 */

public class Animal implements Comparable<Animal> {
    private static int counter;
    private int id;
    private String name;
    private Person owner;
    private int weight;
    private final UUID uuid = UUID.randomUUID();


    Animal(String name, Person person, int weight) {
        ++counter;
        id = counter;
        this.name = name;
        owner = person;
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal o) {
        int result = owner.compareTo(o.owner);
        if (result != 0) {
            return result;
        }
        result = name.compareToIgnoreCase(o.name);
        if (result != 0) {
            return result;
        }
        return  weight - o.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (id != animal.id) return false;
        if (weight != animal.weight) return false;
        if (!name.equals(animal.name)) return false;
        if (!owner.equals(animal.owner)) return false;
        return uuid.equals(animal.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                ", weight=" + weight +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
