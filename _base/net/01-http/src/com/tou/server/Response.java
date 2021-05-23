package com.tou.server;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Response {

    public Response() {
        setContentType(getContentType());
    }

    public Response(String protocol, Integer code, String msg) {
        this.protocol = protocol;
        this.code = code;
        this.msg = msg;
    }

    private String protocol = "HTTP/1.1";

    private Integer code = 200;

    private String msg = "OK";

    private Map<String, String> header = new HashMap<>();

    private String data;

    private String contentType = "text/html; charset=utf-8";

    private String contentLength;


    public String buildResponse() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getProtocol()).append(" ")
                .append(this.getCode()).append(" ")
                .append(this.getMsg()).append("\r\n");

        this.getHeader().forEach((key, val) -> {
            sb.append(key).append(": ").append(val).append("\r\n");
        });

        sb.append("\r\n").append(this.getData());

        return sb.toString();
    }

    public void write(OutputStream os) {
        try {
            os.write(buildResponse().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addHeader(String key, String val) {
        this.getHeader().put(key.toLowerCase().trim(), val.toLowerCase().trim());
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
        this.getHeader().put("content-type", contentType);
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.getHeader().put("content-length", contentLength);
        this.contentLength = contentLength;
    }


    public String getProtocol() {
        return protocol;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.setContentLength(data.getBytes(StandardCharsets.UTF_8).length + "");
        this.data = data;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }

    public Map<String, String> getHeader() {
        return header;
    }
}
