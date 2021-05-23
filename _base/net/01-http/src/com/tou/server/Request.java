package com.tou.server;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private String type;
    private String url;
    private String protocol;

    // 头
    private String contentType;

    private Map<String, String> headers = new HashMap<>();

    private Map<String, String> attributes = new HashMap<>();

    @Override
    public String toString() {
        return "Request{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", protocol='" + protocol + '\'' +
                ", contentType='" + contentType + '\'' +
                ", headers=" + headers +
                ", attributes=" + attributes +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public static Request buildRequest(String requestStr) {
        Request request = new Request();

        String[] strings = requestStr.split("\r\n\r\n");

        // 请求行 和 请求头
        String[] lineAndHeader = strings[0].split("\r\n");

        // 请求行
        String[] lines = lineAndHeader[0].split(" ");
        if (lines.length < 2) return null;
        request.setType(lines[0]);
        request.setUrl(lines[1]);
        request.setProtocol(lines[2]);

        for (int i = 1; i < lineAndHeader.length; i++) {
            String[] header = lineAndHeader[i].split(": ");
            request.getHeaders().put(header[0].trim().toLowerCase(), header[1].trim().toLowerCase());
        }

        request.setContentType(request.getHeaders().get("content-type"));


        // 处理请求体
        if (strings.length == 2) {

        }

        return request;
    }
}
