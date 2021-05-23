package com.tou.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static com.tou.server.HttpUtils.*;

public class MyTask extends Thread {

    Socket accept;

    public MyTask(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        InputStream in;
        OutputStream out = null;
        try {
            in = accept.getInputStream();
            StringBuilder sb = new StringBuilder();
            byte[] buf = new byte[512];
            int len;
            while ((len = in.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
                if (len < 512) accept.shutdownInput(); // 关闭输入
            }

            Request request = Request.buildRequest(sb.toString());

            if (request == null) return;

            String url = request.getUrl();

            if ("favicon.ico".equals(url) || "".equals(url)) return;

            out = accept.getOutputStream();
            Response response = new Response();
            String html = getPage(request.getUrl());
            response.setData(html);

            response.addHeader("a", "b");

            response.write(out); // 关闭


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
                if (accept != null) accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
