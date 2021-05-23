package com.tou.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MsgHandler extends Thread {

    Socket accept;

    public MsgHandler(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = accept.getInputStream();
            byte[] buf = new byte[1024];
            int len;

            while ((len = inputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
