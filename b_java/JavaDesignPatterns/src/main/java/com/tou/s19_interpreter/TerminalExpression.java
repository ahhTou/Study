package com.tou.s19_interpreter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TerminalExpression implements Expression {

    private String data;

    @Override
    public boolean interpret(String context) {
        return context.contains(data);
    }
}
