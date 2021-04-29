package com.tou.s15_iterator;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
public class OutputImpl {
    List<College> collegeList;


    // 遍历所有学院，然后调用printDepartment 输出各个院系的系
    public void printCollege() {
        Iterator<College> iterator = collegeList.listIterator();

        while (iterator.hasNext()) {
            College next = iterator.next();
            System.out.println("----" + next.getName() + "----");
            printDepartment(next.createIterator());
        }
    }

    // 输入学院输出系
    public void printDepartment(Iterator<Department> iterator) {
        while (iterator.hasNext()) {
            Department next = iterator.next();
            System.out.println(next.getName() + " -> " + next.getDesc());
        }
    }
}
