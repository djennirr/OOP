package ru.nsu.dubrovin;

import java.util.HashMap;

public class Number extends Expression{
    private int value;

    public Number(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public double eval(HashMap<String, Double> evaluation) {
        return value;
    }

    @Override
    public Expression derivative(String str) {
        return new Number(0);
    }
}
