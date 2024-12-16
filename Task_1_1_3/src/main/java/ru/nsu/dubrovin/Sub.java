package ru.nsu.dubrovin;

import java.util.HashMap;

/**
 * Class for sub.
 */
public class Sub extends Expression {
    private Expression firstArg;
    private Expression secondArg;

    /**
     * Constructor.
     *
     * @param firstArg first argument of mul.
     *
     * @param secondArg second argument of mul.
     */
    public Sub(Expression firstArg, Expression secondArg) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    /**
     * Evaluates expression by hashmap.
     *
     * @param evaluation hashmap for evaluation.
     *
     * @return evaluated expression.
     *
     * @throws Exception sometimes we cannot evaluate.
     */
    @Override
    public double eval(HashMap<String, Double> evaluation) throws Exception {
        return firstArg.eval(evaluation) - secondArg.eval(evaluation);
    }

    /**
     * Converts expr to string.
     *
     * @return string representation of expression.
     */
    @Override
    public String toString() {
        return "(" + firstArg.toString() + "-" + secondArg.toString() + ")";
    }

    /**
     * Counts derivative for expression.
     *
     * @param variable variable to derivate.
     *
     * @return derivative.
     */
    @Override
    public Expression derivative(String variable) {
        return new Add(firstArg.derivative(variable), secondArg.derivative(variable));
    }
}
