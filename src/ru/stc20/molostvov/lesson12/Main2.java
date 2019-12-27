package ru.stc20.molostvov.lesson12;

import javassist.CannotCompileException;

public class Main2 {
    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    public static void main(String args[])
    {
        for (int i = 0; i < 100000; i++) {
            try {
                Class c = cp.makeClass("class" + i).toClass();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        }
    }
}