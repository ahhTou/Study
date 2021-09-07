package com.tou.s03_prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProSheep implements Cloneable {
    private String name;
    private int age;
    private String color;

    /**
     * 克隆该实例， 使用默认的clone方法来完成
     *
     * @return 羊
     */
    @Override
    protected ProSheep clone() {
        ProSheep sheep = null;
        try {
            sheep = (ProSheep) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
