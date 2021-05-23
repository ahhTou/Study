package com.tou.tcp;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();

        Socket socket = new Socket();// 可以不用绑定端口，自动绑定
        socket.connect(new InetSocketAddress(InetAddress.getByName("localhost"), 4000));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(msg.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
        socket.close();


    }
}
