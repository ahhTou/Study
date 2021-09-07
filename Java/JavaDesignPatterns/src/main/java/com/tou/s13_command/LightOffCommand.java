package com.tou.s13_command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LightOffCommand implements Command {
    // 聚合LightReceiver
    LightReceiver light;

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
