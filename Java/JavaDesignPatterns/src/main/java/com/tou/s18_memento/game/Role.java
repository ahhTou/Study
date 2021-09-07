package com.tou.s18_memento.game;

import lombok.Data;

@Data
public class Role {
    private int vit;
    private int def;

    // 创建State ，根据当前的状态得到State
    public GameState createState() {
        return new GameState(vit, def);
    }

    // 从备忘录对象那个，恢复Role的状态
    public void recoverGameRoleFromStateManager(GameState gameState) {
        this.vit = gameState.getVit();
        this.def = gameState.getDef();
    }

    // 显示当前游戏角色的状态
    public void display() {
        System.out.println("当前角色的攻击力 : " + this.vit);
        System.out.println("当前角色的防御力 : " + this.def);
    }
}
