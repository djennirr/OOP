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
            return new Number((int) (firstArgSfied.evaluate("") - secondArgSfied.evaluate("")));
        }

        if (secondArgSfied instanceof  Number) {
            if (secondArgSfied.evaluate("") == 0) {
                return firstArgSfied;
            }
        }
        //We cannot do anything about case when first arg is 0.

        if (firstArgSfied.toString().equals(secondArgSfied.toString())){
            return new Number(0);
        }

        return new Sub(firstArgSfied, secondArgSfied);
    }
}
