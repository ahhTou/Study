package com.tou.tcp;


import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws Exception {

        // 1. 创建一个服务器
        ServerSocket serverSocket = new ServerSocket();

        // 2. 绑定端口进行监听
        serverSocket.bind(new InetSocketAddress(4000));
        System.out.println("服务器已经启动 - PORT : 4000");

        // 3. 进行监听
        while (true) {
            Socket accept = serverSocket.accept();
            new MsgHandler(accept).start();
        }


    }

}
