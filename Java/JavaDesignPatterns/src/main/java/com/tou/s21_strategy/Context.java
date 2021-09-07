package com.tou.s21_strategy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Context {
    private final Strategy strategy;

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
