package com.tou.s15_iterator;

import java.util.Iterator;

public class ComputerCollegeIterator implements Iterator<Department> {
    // 这里我们需要知道Department 是以怎样的方式存放的
    Department[] departments;
    int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    // 判断是否还有下一个
    @Override
    public boolean hasNext() {
        return position < departments.length
                && departments[position] != null;
    }

    // 下一个
    @Override
    public Department next() {
        return departments[position++];
    }

    // 删除的方法，空实现
    public void remove() {
    }

}
