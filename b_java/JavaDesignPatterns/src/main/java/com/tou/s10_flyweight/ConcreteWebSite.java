package com.tou.s10_flyweight;

public class ConcreteWebSite extends Website {
    private String type = ""; // 网站发布的形式

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        System.out.println(user.getName() + "使用" +type + "的网站");
    }
}
