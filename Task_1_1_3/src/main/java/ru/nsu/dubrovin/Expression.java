package ru.nsu.dubrovin;

import java.util.HashMap;

/**
 * Abstract class for expressions to derivate.
 */
public abstract class Expression {
    /**
     * Evaluates expression by hashmap.
     *
     * @param evaluation hashmap for evaluation.
     *
     * @return evaluated expression.
     *
     * @throws Exception sometimes we cannot evaluate.
     */
    public abstract double eval(HashMap<String, Double> evaluation) throws Exception;

    /**
     * Converts expr to string.
     *
     * @return string representation of expression.
     */
    public abstract String toString();

    /**
     * Creating hashmap name - value for eval.
     *
     * @param str string representation of expression.
     *
     * @return hashmap.
     */
    private HashMap<String, Double> stringToMap(String str) {
        HashMap<String, Double> map = new HashMap<>();
        String[] statements = str.replace(" ", "").split(";");
        for (String statement : statements) {
            String[] results = statement.split("=");
            if (results.length == 2) {
                String vari = results[0];
                Double val = Double.parseDouble(results[1]);
                map.put(vari, val);
            }
        }
        return map;
    }

    /**
     * Evaluates expression by string evaluation.
     *
     * @param str string for evaluation.
     *
     * @return evaluated expression.
     *
     * @throws Exception sometimes we cannot evaluate.
     */
    public double evaluate(String str) throws Exception {
        return eval(stringToMap(str));
    }

    /**
     * Counts derivative for expression.
     *
     * @param variable variable to derivate.
     *
     * @return derivative.
     */
    public abstract Expression derivative(String variable);

    /**
     * Method for printing expression.
     */
    public void print() {
        System.out.println(this.toString());
    }
}
