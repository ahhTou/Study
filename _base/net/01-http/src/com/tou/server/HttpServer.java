package com.tou.server;


import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws Exception {
        // 创建服务器
        ServerSocket serverSocket = new ServerSocket();

        // 绑定端口
        serverSocket.bind(new InetSocketAddress(InetAddress.getByName("localhost"), 4888));
        System.out.println("Server is running on port: 4888");

        // 开始监听，阻塞的方法
        while (true) {
            Socket accept = serverSocket.accept();
            String address = accept.getRemoteSocketAddress().toString();
            System.out.println(address + " is coming");
            new MyTask(accept).start();
        }
    }

}
