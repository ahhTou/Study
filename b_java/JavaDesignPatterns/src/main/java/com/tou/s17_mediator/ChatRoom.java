package com.tou.s17_mediator;

import java.util.Date;

/**
 * 中介类
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.print(new Date() + " ");
        System.out.println(" [" + user.getName() + "] : " + message);
    }
}
