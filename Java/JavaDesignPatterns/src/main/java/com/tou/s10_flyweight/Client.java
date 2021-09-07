package com.tou.s10_flyweight;

public class Client {
    public static void main(String[] args) {
        // 创建一个工厂
        WebSiteFactory factory = new WebSiteFactory();

        // 客服要一个以新闻形式发布的网站
        Website web1 = factory.getWebSiteCategory("新闻");
        Website web2 = factory.getWebSiteCategory("新闻");
        Website web3 = factory.getWebSiteCategory("新闻");

        web1.use(new User("小明"));
        web2.use(new User("中明"));
        web3.use(new User("大明"));

        System.out.println("count is " + factory.getWebSiteCount());

    }
}
