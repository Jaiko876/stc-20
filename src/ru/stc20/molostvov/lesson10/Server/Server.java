package ru.stc20.molostvov.lesson10.Server;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

public class Server {
    private static DatagramSocket socket;
    private static boolean running;
    private static ArrayList<ClientInfo> clients = new ArrayList<>();
    private static int id;

    public static void start(int port) {
        try {
            running = true;
            socket = new DatagramSocket(port);
            System.out.println("Server started on port:" + port);
            listen();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        running = false;
    }

    private static void broadcast(String message) {
        for (ClientInfo client : clients) {
            send(message, client.getInetAddress(), client.getPort());
        }
    }

    private static void unicast(String message, String name) {
        for (ClientInfo client : clients) {
            if (client.getName().equals(name)) {
                send(message, client.getInetAddress(), client.getPort());
                return;
            }
        }
    }

    private static void send(String message, InetAddress inetAddress, int port) {
        try {
            message += "\\e";
            byte[] data = message.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, inetAddress, port);
            socket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listen() {
        Thread thread = new Thread(() -> {
            while (running) {
                try {
                    byte[] data = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(data, data.length);
                    socket.receive(packet);

                    String message = new String(data);
                    message = message.substring(0,message.indexOf("\\e"));
                    if (!command(message, packet)) {
                        String name = message.substring(1, message.indexOf(":"));
                        if (message.startsWith("/")) {
                            String rName = message.substring(message.indexOf(":") + 1,message.indexOf(" "));
                            String msg = name + " ->" + message.substring(name.length() + rName.length() + 2);
                            unicast(msg, rName);
                        } else {
                            broadcast(message);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }); thread.start();
    }

    private static boolean command(String message, DatagramPacket packet) {
        if (message.startsWith("\\connect")) {
            String name = message.substring(message.indexOf(":") + 1);
            clients.add(new ClientInfo(id++, name, packet.getAddress(), packet.getPort()));
            broadcast(name + " connected!");
            return true;
        }
        return false;
    }

}
