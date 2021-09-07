package com.tou.s03_prototype.deep_clone;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable, Cloneable {
    public static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    // 因为该类的属性，都是String 因此我们这里使用默认的clone即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
