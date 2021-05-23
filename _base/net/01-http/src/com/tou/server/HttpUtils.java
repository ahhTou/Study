package com.tou.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class HttpUtils {
    public static String getPage(String url) {

        System.out.println("find url -> " + url);

        if ("".equals(url) || "/".equals(url) || url == null) url = "index.html";

        if (url.charAt(0) == '/') url = url.substring(1);

        String path = HttpServer.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        InputStream in = null;
        StringBuilder sb = new StringBuilder();
        int len;
        byte[] buf = new byte[1024];
        try {
            path = path.substring(0, path.lastIndexOf("/"));
            String pageUrl = path + "/pages/" + url;
            File file = new File(pageUrl);
            if (file.exists()) in = new FileInputStream(pageUrl);
            else in = new FileInputStream(path + "/pages/" + "404.html");
            while ((len = in.read(buf)) != -1)
                sb.append(new String(buf, 0, len));

        } catch (FileNotFoundException e) {
            sb.append("<h1>连错误界面都找不到了！毁灭吧</h1>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sb.toString().replace("{{ username }}", "ahhTou");
    }
}
