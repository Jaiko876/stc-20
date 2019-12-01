package ru.stc20.molostvov.lesson09;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        WorkerCreator wc = new WorkerCreator();
        File path = wc.writeFile(wc.buildCode());
        //System.out.println("Hello World!");
        Worker worker = (Worker) wc.compileAndMakeInstance(path);
        worker.doWork();
    }
}
