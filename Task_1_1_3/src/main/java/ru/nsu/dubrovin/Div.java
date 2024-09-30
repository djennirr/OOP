package ru.nsu.dubrovin;

import java.util.HashMap;

public class Div extends Expression{
    private Expression firstArg;
    private Expression secondArg;

    public Div(Expression firstArg, Expression secondArg) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    @Override
    public double eval(HashMap<String, Double> evaluation) {
        return firstArg.eval(evaluation) / secondArg.eval(evaluation);
    }

    @Override
    public String toString() {
        return "(" + firstArg.toString() + "/" + secondArg.toString() + ")";
    }

    @Override
    //ДА КТО ВООБЩЕ ПРИДУМАЛ ТАКУЮ ПРОИЗВОДНУЮ РАЗНОСТИ НЕВОЗМОЖНО
    public Expression derivative(String variable) {
        return new Div(new Sub(new Mul(firstArg.derivative(variable), secondArg),
            new Mul(firstArg, secondArg.derivative(variable))), new Mul(secondArg, secondArg));
    }
}
