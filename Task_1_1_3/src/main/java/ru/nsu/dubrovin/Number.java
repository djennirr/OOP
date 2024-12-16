package ru.nsu.dubrovin;

import java.util.HashMap;

/**
 * Class for Number.
 */
public class Number extends Expression {
    private int value;

    /**
     * Constructor.
     *
     * @param value value of the number.
     */
    public Number(int value) {
        this.value = value;
    }

    /**
     * Converts number to string.
     *
     * @return string convertation of value.
     */
    @Override
    public String toString() {
        return Integer.toString(value);
    }

    /**
     * Evaluates the number by its value.
     *
     * @param evaluation hashmap for evaluation.
     *
     * @return number's value.
     */
    @Override
    public double eval(HashMap<String, Double> evaluation) {
        return value;
    }

    /**
     * Counts derivative for number.
     *
     * @param str variable to derivate.
     *
     * @return 0 (each number's derivative).
     */
    @Override
    public Expression derivative(String str) {
        return new Number(0);
    }
}
