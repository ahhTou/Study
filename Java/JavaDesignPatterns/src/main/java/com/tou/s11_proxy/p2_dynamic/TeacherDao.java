package com.tou.s11_proxy.p2_dynamic;

public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("> 正在教学");
    }

    @Override
    public void sayHello() {
        System.out.println("> 在说Hello");
    }
}
