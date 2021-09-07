package com.tou.s19_interpreter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrExpression implements Expression {

    private Expression expr1 = null;

    private Expression expr2 = null;

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}
