package com.tou.s06_bridge;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Phone {

    // 组合品牌
    private Brand brand;

    protected void open() {
        this.brand.open();
    }

    protected void close() {
        this.brand.close();
    }

    protected void call() {
        this.brand.call();
    }
}
