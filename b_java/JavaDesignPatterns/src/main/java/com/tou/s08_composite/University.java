package com.tou.s08_composite;

import java.util.ArrayList;
import java.util.List;

public class University extends OrganizationComponent {

    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent org) {
        organizationComponents.add(org);
    }

    @Override
    protected void remove(OrganizationComponent org) {
        organizationComponents.remove(org);
    }

    @Override
    protected void print() {
        System.out.println("-----" + getName() + "-----");
        organizationComponents.forEach(OrganizationComponent::print);
    }
}
