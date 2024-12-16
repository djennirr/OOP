package ru.nsu.dubrovin;

import java.util.EmptyStackException;
import java.util.Stack;

public class Parser {

    /**
     * Parsing string to expression.
     *
     * @param toParse string to parse.
     *
     * @return parsed expression.
     *
     * @throws ParserException if the brackets sequence is incorrect it throws exception.
     */
    public Expression parseExpr(String toParse) throws ParserException {
        toParse = toParse.replaceAll(" ", "");

        // We can have many outer brackets and we need to remove them all
        // after removing them we can simply find symbol to be the main action
        // but not always when expr starts and ends with brackets they are outer
        // Eg. (a - b) * (a + b) starts and ends with brackets but we cannot remove them

        //Basically I used quite same solution as in my brainfuck on C for jumps

        //Getting brackets only using regexp
        /*String brackets = toParse.replaceAll("[^()]", "");
        char[] expr = brackets.toCharArray();*/
        char[] expr = toParse.toCharArray();
        int len = toParse.length();
        if (len == 0) {
            throw new ParserException("Empty expression");
        }


        int[] ptrs = new int[len];
        int tmp;
        Stack<Integer> openStack = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (expr[i] == '(') {
                openStack.push(i);
            }

            if (expr[i] == ')') {
                try {
                    tmp = openStack.pop();
                } catch (EmptyStackException e) {
                    throw new ParserException("Inappropriate brackets sequence");
                }
                // Now the cells with indices as opening brackets have ptrs to closing brackets
                ptrs[tmp] = i;
            }
        }

        if (!openStack.empty()) {
            throw new ParserException("Inappropriate brackets sequence");
        }

        int toDelete = 0;
        for (int i = 0; i < len; i++) {
            if ((ptrs[i] == len - 1 - i) && (i < len - 1 - i)) {
                toDelete++;
            } else {
                break;
            }
        }

        toParse = toParse.substring(toDelete, len - toDelete);
        char[] exprr = toParse.toCharArray();
        len = toParse.length();

        int unclosed = 0;
        char c;
        for (int i = 0; i < len; i++) {
            c = exprr[i];
            switch (c) {
                case '(':
                    unclosed++;
                    break;

                case ')':
                    unclosed--;
                    break;

                case '+':
                    if (unclosed == 0) {
                        return new Add(parseExpr(toParse.substring(0, i)),
                                parseExpr(toParse.substring(i + 1)));
                    }
                    break;

                case '-':
                    if (unclosed == 0) {
                        return new Sub(parseExpr(toParse.substring(0, i)),
                                parseExpr(toParse.substring(i + 1)));
                    }
                    break;

                case '*':
                    if (unclosed == 0) {
                        return new Mul(parseExpr(toParse.substring(0, i)),
                                parseExpr(toParse.substring(i + 1)));
                    }
                    break;

                case '/':
                    if (unclosed == 0) {
                        return new Div(parseExpr(toParse.substring(0, i)),
                                parseExpr(toParse.substring(i + 1)));
                    }
                    break;

                default:
            }
        }

        if (toParse.matches("\\d+")) {
            return new Number(Integer.parseInt(toParse));
        }
        return new Variable(toParse);
    }
}
