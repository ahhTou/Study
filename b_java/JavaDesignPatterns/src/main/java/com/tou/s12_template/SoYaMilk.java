package com.tou.s12_template;

public abstract class SoYaMilk {

    // 不让子类覆盖
    final void make() {
        select();
        addCondiments();
        soak();
        beat();
    }

    // 选材料
    void select() {
        System.out.println(" 第一步： 选择好的新鲜黄豆 ");
    }

    // 添加不同的配料
    abstract void addCondiments();

    // 侵泡
    void soak() {
        System.out.println(" 第三步： 黄豆和配料 开始侵泡， 需要三个消失 ");
    }

    void beat() {
        System.out.println(" 第四部： 黄豆和配料 放入到豆浆机去打碎 ");
    }
}
