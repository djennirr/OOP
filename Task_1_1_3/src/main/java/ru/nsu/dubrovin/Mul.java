package ru.nsu.dubrovin;

import java.util.HashMap;

public class Mul extends Expression{
    private Expression firstArg;
    private Expression secondArg;

    public Mul(Expression firstArg, Expression secondArg) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    @Override
    public double eval(HashMap<String, Double> evaluation) {
        return firstArg.eval(evaluation) * secondArg.eval(evaluation);
    }

    @Override
    public String toString() {
        return "(" + firstArg.toString() + "*" + secondArg.toString() + ")";
    }

    @Override
    public Expression derivative(String variable) {
        return new Add(new Mul(firstArg.derivative(variable), secondArg),
            new Mul(firstArg, secondArg.derivative(variable)));
    }
}
