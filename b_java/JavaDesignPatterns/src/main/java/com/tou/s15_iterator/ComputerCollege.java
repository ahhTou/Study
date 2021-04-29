package com.tou.s15_iterator;

import java.util.Iterator;

public class ComputerCollege implements College {
    Department[] departments;

    int numOfDepartments = 0; // 当前数组的对象个数

    public ComputerCollege() {
        this.departments = new Department[5];
        addDepartment("Java专业", "Java专业");
        addDepartment("PHP专业", "PHP专业");
        addDepartment("大数据专业", "大数据专业");
        addDepartment("软件专业", "软件专业");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartments++] = department;

    }

    @Override
    public Iterator<Department> createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
