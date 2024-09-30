package ru.nsu.dubrovin;

import java.util.HashMap;

public abstract class Expression {
    public abstract double eval(HashMap<String, Double> evaluation);

    public abstract String toString();

    //Получаем хэшмапу название - значение из строки
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

    public double evaluate(String str) {
        return eval(stringToMap(str));
    }

    public abstract Expression derivative(String variable);

    public void print(){
        System.out.println(this);
    }
}
