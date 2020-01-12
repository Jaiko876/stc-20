package ru.stc20.molostvov.lesson10.Server;

import java.net.InetAddress;

public class ClientInfo {
    private int id;
    private String name;
    private InetAddress inetAddress;
    private int port;

    public ClientInfo(int id, String name, InetAddress inetAddress, int port) {
        this.id = id;
        this.name = name;
        this.inetAddress = inetAddress;
        this.port = port;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public int getPort() {
        return port;
    }
}


