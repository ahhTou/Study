package com.tou.s15_iterator;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College {

    List<Department> departmentList = new ArrayList<>();

    public InfoCollege() {
        addDepartment("网络安全", "网络安全");
        addDepartment("服务器安全", "服务器安全");
        addDepartment("信息安全", "信息安全");
    }

    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        departmentList.add(new Department(name, desc));
    }

    @Override
    public Iterator<Department> createIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}
