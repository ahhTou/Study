package com.tou.s18_memento.game;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 守护者对象
 */
@Data
public class StateManager {
    // 只保存一次对象
    private GameState gameState;

    // 对 GameRole 保存多次对象
    private ArrayList<GameState> gameStates;

    // 对多个游戏角色保存多个对象
    private HashMap<String, ArrayList<GameState>> roles;


}
