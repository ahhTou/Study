package com.tou.s15_iterator;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator<Department> {

    List<Department> departmentList;
    int index = 0; // 索引

    public InfoCollegeIterator(List<Department> department) {
        this.departmentList = department;
    }

    @Override
    public boolean hasNext() {
        return departmentList.size() > index;
    }

    @Override
    public Department next() {
        if (!hasNext()) return null;
        return departmentList.get(index++);
    }

    // 空实现remove
    public void remove() {
    }
}
