package ru.nsu.dubrovin;

import java.util.HashMap;

public class Variable extends Expression{
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public double eval(HashMap<String, Double> evaluation) throws Exception {
        if (evaluation.get(name) == null) {
            throw new Exception("Cannot evaluate");
        }
        return evaluation.get(name);
    }

    @Override
    public Expression derivative(String variable) {
        if (name.equals(variable)) {
            return new Number(1);
        } else {
            return new Number(0);
        }
    }
}
