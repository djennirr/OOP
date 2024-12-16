package ru.nsu.dubrovin;

import java.util.HashMap;

/**
 * Class for mul.
 */
public class Mul extends Expression {
    private final Expression firstArg;
    private final Expression secondArg;

    /**
     * Constructor.
     *
     * @param firstArg first argument of mul.
     *
     * @param secondArg second argument of mul.
     */
    public Mul(Expression firstArg, Expression secondArg) {
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
        return firstArg.eval(evaluation) * secondArg.eval(evaluation);
    }

    /**
     * Converts expr to string.
     *
     * @return string representation of expression.
     */
    @Override
    public String toString() {
        return "(" + firstArg.toString() + "*" + secondArg.toString() + ")";
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
        return new Add(new Mul(firstArg.derivative(variable), secondArg),
            new Mul(firstArg, secondArg.derivative(variable)));
    }

    /**
     * Simplifies add expression.
     *
     * @return simplified add expression.
     *
     * @throws Exception in case we are calling evaluate, but it actually do not throw exception.
     */
    @Override
    public Expression simplify() throws Exception {
        Expression firstArgSfied = this.firstArg.simplify();
        Expression secondArgSfied = this.secondArg.simplify();

        if (firstArgSfied instanceof Number && secondArgSfied instanceof Number) {
            return new Number((int) (firstArgSfied.evaluate("") * secondArgSfied.evaluate("")));
        }

        if (firstArgSfied instanceof Number) {
            if (firstArgSfied.evaluate("") == 1) {
                return secondArgSfied;
            }
        }

        if (firstArgSfied instanceof Number) {
            if (firstArgSfied.evaluate("") == 0) {
                return new Number(0);
            }
        }

        if (secondArgSfied instanceof  Number) {
            if (secondArgSfied.evaluate("") == 1) {
                return firstArgSfied;
            }
        }

        if (secondArgSfied instanceof  Number) {
            if (secondArgSfied.evaluate("") == 0) {
                return new Number(0);
            }
        }

        return new Mul(firstArgSfied, secondArgSfied);
    }
}
