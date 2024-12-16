package ru.nsu.dubrovin;

import java.util.HashMap;

/**
 * Class for variable.
 */
public class Variable extends Expression {
    private String name;

    /**
     * Constructor.
     *
     * @param name variable name.
     */
    public Variable(String name) {
        this.name = name;
    }

    /**
     * Converts number to string.
     *
     * @return string variable's name.
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Evaluates variable by hashmap.
     *
     * @param evaluation hashmap for evaluation.
     *
     * @return evaluated variable.
     *
     * @throws Exception sometimes we cannot evaluate.
     */
    @Override
    public double eval(HashMap<String, Double> evaluation) throws VariableException {
        if (evaluation.get(name) == null) {
            throw new VariableException("Cannot evaluate");
        }
        return evaluation.get(name);
    }

    /**
     * Counts derivative for number.
     *
     * @param variable variable to derivate.
     *
     * @return 0 (if the derivative is taken not by that variable) or 1.
     */
    @Override
    public Expression derivative(String variable) {
        if (name.equals(variable)) {
            return new Number(1);
        } else {
            return new Number(0);
        }
    }
}
