package ru.stc20.molostvov.lesson10.Client;

import java.util.Scanner;

public class ClientUI {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Write ur name: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            Client client = new Client(name, "localhost", 7866);
            while (true) {
                String line = scanner.nextLine();
                if (line.equals("quit"))
                    break;
                client.send(line);
            }
            client.send("\\quit");
        }); thread.start();
    }
}
