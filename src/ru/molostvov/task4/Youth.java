package ru.molostvov.task4;

public class Youth extends Visitors{
    public Youth(String name) {
        super(name);
    }
    protected void drinking(Pond pond) {
        System.out.println(this.getName() + " пьёт у пруда!");
        pond.setI(1);
    }

    @Override
    protected void watch() {
        super.watch();
        System.out.println(this.getName() + " настроен сделать что-то неладное!");
    }
}
