package com.tou.s13_command;

public class RemoteController {
    // 开 按钮的命令的数组
    Command[] onCommands;
    Command[] offCommands;

    // 执行撤销的命令
    Command undoCommand;

    // 构造器 完成对按钮的初始化
    public RemoteController() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for (int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    // 给我们的按钮的设置你需要的命令
    public void setOnCommand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    // 按下开按钮
    public void onButtonWasPushed(int no) {
        // 找到你按下的按钮
        onCommands[no].execute();

        // 机录这次的操作，用于撤销
        undoCommand = offCommands[no];

    }

    // 按下开按钮
    public void offButtonWasPushed(int no) {
        // 找到你按下的关按钮， 并调用对应的方法
        offCommands[no].execute();

        // 机录这次的操作，用于撤销
        undoCommand = offCommands[no];

    }

    // 撤销按钮的处理
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

}
