package ru.molostvov.task29;

public class Person {
    private String lastName;
    private int age;
    private String sex;

    Person( int age, String lastName, String sex) {
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        return sex != null ? sex.equals(person.sex) : person.sex == null;

    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
