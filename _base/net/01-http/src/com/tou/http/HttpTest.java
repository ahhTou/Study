package com.tou.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpTest {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();

        server.bind(new InetSocketAddress(8888));

        System.out.println("等待 Http 请求\r\n");

        // 阻塞方法 一直等待 请求
        Socket accept = server.accept();

        InputStream inputStream = accept.getInputStream();

        byte[] buff = new byte[1024];

        int len = inputStream.read(buff);

        System.out.println(new String(buff, 0, len));

    }

}
