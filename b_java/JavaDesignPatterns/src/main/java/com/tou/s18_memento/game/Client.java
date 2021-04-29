package com.tou.s18_memento.game;

public class Client {
    public static void main(String[] args) {
        Role role = new Role();
        role.setDef(100);
        role.setVit(100);

        System.out.println("和Boss大战前的状态");
        role.display();

        // 把当前状态保存起来
        StateManager stateManager = new StateManager();
        stateManager.setGameState(role.createState());

        System.out.println("和Boss大战~~~");
        role.setVit(30);
        role.setDef(30);
        role.display();

        System.out.println("恢复~~~~");

        role.recoverGameRoleFromStateManager(stateManager.getGameState());

        role.display();
    }
}
