package com.tou.s11_proxy.p1_static;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TeacherDaoProxy implements ITeacherDao {
    // 目标对象，通过接口来聚合
    private final ITeacherDao target;

    @Override
    public void teach() {
        System.out.println("开始代理。。。。");
        target.teach();
        System.out.println("代理结束");
    }
}
