package com.tou.s11_proxy.p1_static;


import lombok.AllArgsConstructor;

/**
 * 代理对象， 静态代理
 */
@AllArgsConstructor
public class TeacherDao implements ITeacherDao {

    @Override
    public void teach() {
        System.out.println("> 开始教学");
    }
}
