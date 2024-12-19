package ru.nsu.dubrovin;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Class for polish cow parser.
 */

public class CowParser {

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

        if (toParse.isEmpty()) {
            throw new ParserException("Empty expression");
        }

        ArrayList<String> rpn = infixToRPN(toParse);

        return buildExpressionTree(rpn);
    }

    /**
     * Convert expression to reverse polish notation.
     *
     * @param expression expression without spaces.
     *
     * @return expression in reverse polish notation.
     *
     * @throws ParserException in case we got inappropriate brackets sequence or operator.
     */
    private ArrayList<String> infixToRPN(String expression) throws ParserException {
        ArrayList<String> output = new ArrayList<>();
        ArrayDeque<Character> operators = new ArrayDeque<>();

        int len = expression.length();
        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                while (i < len && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    number.append(expression.charAt(i));
                    i++;
                }
                i--;
                output.add(number.toString());
            } else if (Character.isLetter(c)) {
                StringBuilder variable = new StringBuilder();
                while (i < len && Character.isLetter(expression.charAt(i))) {
                    variable.append(expression.charAt(i));
                    i++;
                }
                i--;
                output.add(variable.toString());
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.add(String.valueOf(operators.pop()));
                }
                if (operators.isEmpty()) {
                    throw new ParserException("Inappropriate brackets sequence");
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && priority(operators.peek()) >= priority(c)) {
                    output.add(String.valueOf(operators.pop()));
                }
                operators.push(c);
            } else {
                throw new ParserException("Invalid operator: " + c);
            }
        }

        while (!operators.isEmpty()) {
            char op = operators.pop();
            if (op == '(' || op == ')') {
                throw new ParserException("Inappropriate brackets sequence");
            }
            output.add(String.valueOf(op));
        }

        return output;
    }

    /**
     * Building tree of expressions.
     *
     * @param rpn expression in reverse polish notation.
     *
     * @return expression, which is result of parsing.
     *
     * @throws ParserException if we don't have enough args.
     */
    private Expression buildExpressionTree(ArrayList<String> rpn) throws ParserException {
        ArrayDeque<Expression> stack = new ArrayDeque<>();

        for (String token : rpn) {
            if (isNumber(token)) {
                stack.push(new Number(Integer.parseInt(token)));
            } else if (isVariable(token)) {
                stack.push(new Variable(token));
            } else if (isOperator(token.charAt(0))) {
                if (stack.size() < 2) {
                    throw new ParserException("Not enough arguments");
                }
                Expression right = stack.pop();
                Expression left = stack.pop();

                switch (token.charAt(0)) {
                    case '+':
                        stack.push(new Add(left, right));
                        break;
                    case '-':
                        stack.push(new Sub(left, right));
                        break;
                    case '*':
                        stack.push(new Mul(left, right));
                        break;
                    case '/':
                        stack.push(new Div(left, right));
                        break;
                    default:
                        throw new ParserException("Unknown operator: " + token);
                }
            } else {
                throw new ParserException("Invalid token: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new ParserException("Invalid expression");
        }

        return stack.pop();
    }

    /**
     * Checking whether is string a number.
     *
     * @param str string to check.
     *
     * @return true or false.
     */
    private boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checking whether is string a variable.
     *
     * @param str string to check.
     *
     * @return true or false.
     */
    private boolean isVariable(String str) {
        return str.matches("[a-zA-Z]+");
    }

    /**
     * Checking whether is string an operator.
     *
     * @param c character to check.
     *
     * @return true or false.
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Returns priority of an operator.
     *
     * @param operator character to check.
     *
     * @return 1 if + or -, 2 if * or / and -1 otherwise.
     */
    private int priority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}
