package com.tou.s17_mediator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    String name;


    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
