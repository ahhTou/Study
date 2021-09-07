package com.tou.s13_command;

/**
 * 没有任何命令，即空执行, 当调用空指令时，对象什么都不做
 * 其实，这样也是设计模式，可以声调对空判断
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
