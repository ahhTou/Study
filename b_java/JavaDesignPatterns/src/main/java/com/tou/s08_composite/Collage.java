package com.tou.s08_composite;

import java.util.ArrayList;
import java.util.List;

public class Collage extends OrganizationComponent {


    public Collage(String name, String desc) {
        super(name, desc);
    }

    // 存放的是Department
    List<OrganizationComponent> department = new ArrayList<>();

    @Override
    protected void print() {
        System.out.println(getName());
        department.forEach(OrganizationComponent::print);
    }

    @Override
    protected void remove(OrganizationComponent org) {
        department.remove(org);
    }

    @Override
    protected void add(OrganizationComponent org) {
        department.add(org);
    }
}
