package com.tou.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Url {

    public static final String BASE_URL = "D:\\code\\_base\\net\\";

    public static void main(String[] args) throws Exception {
        download("https://activity.hdslb.com/zzjs/20160608appDownload/img/pc/QRcode.png");
        download("https://app-search.cdnjtzy.com/xfe-question/_nuxt/img/question-QRCode.44e885c.png");
    }

    private static void download(String url) throws IOException {
        URL fileURL = new URL(url);
        String filename = fileURL.getFile().substring(fileURL.getFile().lastIndexOf("/") + 1);
        InputStream inputStream = fileURL.openStream();

        File file = new File(BASE_URL + filename);
        
        if (!file.createNewFile()) {
            System.out.println("× 创建文件失败！终止下载");
            return;
        }
        FileOutputStream outputStream = new FileOutputStream(file);

        System.out.println("将要下载文件: " + filename);

        byte[] buf = new byte[1024];
        int len;
        while ((len = inputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, len);
            outputStream.flush();
        }

        outputStream.close();
        inputStream.close();
    }
}
