package com.tou.s15_iterator;

import java.util.Iterator;

public interface College {

    String getName();


    // 增加系的方法
    void addDepartment(String name, String desc);

    // 返回一个迭代器，变离
    public Iterator<Department> createIterator();

}
