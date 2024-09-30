package ru.nsu.dubrovin;

import java.util.HashMap;

public class Sub extends Expression{
    private Expression firstArg;
    private Expression secondArg;

    public Sub(Expression firstArg, Expression secondArg) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    @Override
    public double eval(HashMap<String, Double> evaluation) {
        return firstArg.eval(evaluation) - secondArg.eval(evaluation);
    }

    @Override
    public String toString() {
        return "(" + firstArg.toString() + "-" + secondArg.toString() + ")";
    }

    @Override
    public Expression derivative(String variable) {
        return new Add(firstArg.derivative(variable), secondArg.derivative(variable));
    }
}
