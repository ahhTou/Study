package com.tou.s13_command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LightOnCommand implements Command {

    // 聚合LightReceiver
    LightReceiver light;

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
