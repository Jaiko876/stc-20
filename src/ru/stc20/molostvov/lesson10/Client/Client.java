package ru.stc20.molostvov.lesson10.Client;

import java.io.IOException;
import java.net.*;

public class Client {
    private String name;
    private DatagramSocket datagramSocket;
    private int port;
    private InetAddress inetAddress;
    private boolean running;

    public Client(String name, String inetAddress, int port) {
        this.name = name;
        this.port = port;
        try {
            datagramSocket = new DatagramSocket();
            this.inetAddress = InetAddress.getByName(inetAddress);
            send("\\connect:" + name);
            running = true;
            listen();
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        try {
            String msg;
            if (message.startsWith("\\quit")) {
                msg = name + " disconnected!" + "\\e";
                running = false;
            } else if (message.startsWith("\\connect")) {
                msg = message + "\\e";
            } else if (message.startsWith("/")) {
                msg = "/" + name + ":" + message.substring(1) + "\\e";
            } else {
                msg = name + ":" + message + "\\e";
            }
            byte[] data = msg.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, port);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {
        Thread thread = new Thread(() -> {
            while (running) {
                try {
                    byte[] data = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(data, data.length);
                    datagramSocket.receive(packet);

                    String message = new String(data);
                    message = message.substring(0,message.indexOf("\\e"));
                    System.out.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }); thread.start();
    }
}
