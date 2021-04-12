package com.tou.s0_principle.s6_demeter.improve;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class DemeterPro {

    public static void main(String[] args) {
        // 创建了一个 SchoolManager 对象
        System.out.println("遵守迪米特法则");
        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }

}

/**
 * 学校总部员工类
 */
@Data
class Employee {
    private String id;
}

/**
 * 学校员工类
 */
@Data
class CollegeEmployee {
    private String id;
}

/**
 * 管理序员员工的管理类
 */
class CollegeManager {
    // 返回学校的所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // 添加了10个员工
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学习员工id = " + i);
            list.add(emp);
        }
        return list;
    }

    public void printEmployee() {
        List<CollegeEmployee> list1 = this.getAllEmployee();
        System.out.println("--- 分公司员工 ---");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
    }
}

/**
 * 学校的管理类
 * SchoolManager 的直接朋友： Employee、CollegeManager
 * CollegeManager 不是 直接朋友 违背了 迪米特原则
 */
class SchoolManager {
    // 返回学校总部的员工
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // 这里添加了5个员工到list
            Employee emp = new Employee();
            emp.setId("学校总部员工id = " + i);
            list.add(emp);
        }
        return list;
    }

    // 打印所有员工
    void printAllEmployee(CollegeManager sub) {
        /*
         * 分析问题
         * 1. 将输出学院的员工方法， 封装到CollegeManager
         */


        List<Employee> list2 = this.getAllEmployee();
        System.out.println("--- 学校总部员工 ---");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }

        sub.printEmployee();
    }
}
