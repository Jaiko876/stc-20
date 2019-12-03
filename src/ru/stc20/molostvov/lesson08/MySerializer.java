package ru.stc20.molostvov.lesson08;

public interface MySerializer {
    void serialize (Object object, String file);
    Object deSerialize(String file);
}
