package ru.nsu.dubrovin;

import java.util.HashMap;

/**
 * Class for div.
 */
public class Div extends Expression{
    private final Expression firstArg;
    private final Expression secondArg;

    /**
     * Constructor.
     *
     * @param firstArg first argument of div.
     *
     * @param secondArg second argument of div.
     */
    public Div(Expression firstArg, Expression secondArg) {
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
        return firstArg.eval(evaluation) / secondArg.eval(evaluation);
    }

    /**
     * Converts expr to string.
     *
     * @return string representation of expression.
     */
    @Override
    public String toString() {
        return "(" + firstArg.toString() + "/" + secondArg.toString() + ")";
    }

    /**
     * Counts derivative for expression.
     *
     * @param variable variable to derivate.
     *
     * @return derivative.
     */
    @Override
    //ДА КТО ВООБЩЕ ПРИДУМАЛ ТАКУЮ ПРОИЗВОДНУЮ РАЗНОСТИ НЕВОЗМОЖНО
    public Expression derivative(String variable) {
        return new Div(new Sub(new Mul(firstArg.derivative(variable), secondArg),
            new Mul(firstArg, secondArg.derivative(variable))), new Mul(secondArg, secondArg));
    }
}
