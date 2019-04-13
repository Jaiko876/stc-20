package ru.Molostvov.Task1;

public class RealSalary {

    public static void main(String[] args) {
        int salary = 70000;
        int tax = salary * 13 / 100;
        int realSalary = salary - tax;
        System.out.println(realSalary + "руб");
    }
}
