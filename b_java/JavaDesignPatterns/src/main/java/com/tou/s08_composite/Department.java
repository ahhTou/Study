package com.tou.s08_composite;

public class Department extends OrganizationComponent {

    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void print() {
        System.out.println("Department is" + getName() + " && " + getDesc());
    }
}
