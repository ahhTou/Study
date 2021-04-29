package com.tou.s13_command;

public interface Command {

    // 执行动作，操作
    void execute();

    // 撤销动作，操作
    void undo();

}
