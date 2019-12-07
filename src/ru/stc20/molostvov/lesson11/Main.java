package ru.stc20.molostvov.lesson11;

public class Main {
    public static void main(String[] args) {
        GeneratorBuilder generatorBuilder = Generator::new;
        Generator generator = generatorBuilder.create(10);
        generator.doMaths(generator.getArray(), generator::maths);
    }
}
