package com.coding.string;

import java.util.Stack;

public class Q1106_parsingaBooleanExpression {
    public static void main(String[] args) {
        test("!(f)", true);
        test("&(t,f)", false);
        test("|(f,t)", true);
        test("|(&(t,f,t),!(t))", false);
    }

    private static void test(String s, boolean b) {
        Q1106_parsingaBooleanExpression q1106 = new Q1106_parsingaBooleanExpression();
        boolean res = q1106.parseBoolExpr(s);
        if (res != b){
            throw new RuntimeException(s + " is not expected " + b);
        }
    }


    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] arr = expression.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(isExprChar(arr[i])){
                handleExpChar(stack, arr[i]);
            }else if(isftChar(arr[i])){
                handleftChar(stack, arr[i]);
            }else if(isEndChar(arr[i])){
                handleEndChar(stack);
            }
        }
        return stack.pop() == 't' ? true : false;
    }

    private void handleEndChar(Stack<Character> stack) {
        char res = handlePatternOfExpAndOneChar(stack);
        if(stack.isEmpty()){
            handleExpChar(stack, res);
        }else{
            handleftChar(stack, res);
        }
    }

    private void handleExpChar(Stack<Character> stack, char c) {
        stack.push(c);
    }

    private void handleftChar(Stack<Character> stack, char c) {
        if (isExpParttern(stack)) {
            stack.push(c);
        } else {
            handlePatternOfExpAndTwoChar(stack, c);
        }
    }

    private boolean isExpParttern(Stack<Character> stack) {
        char peekC = stack.peek();
        return !isftChar(peekC);
    }

    private char handlePatternOfExpAndOneChar(Stack<Character> stack) {
        char first = stack.pop();
        char exp = stack.pop();
        return parse(exp, first);
    }


    private void handlePatternOfExpAndTwoChar(Stack<Character> stack, char elem) {
        char first = stack.pop();
        char exp = stack.peek();
        char res = parse(exp, first, elem);
        stack.push(res);
    }

    private boolean isEndChar(char c) {
        return c == ')';
    }

    private boolean isftChar(char c) {
        return c == 'f' || c == 't';
    }

    private boolean isExprChar(char c) {
        return c == '!' || c == '|' || c == '&';
    }

    private char parse(char exp, char first) {
        boolean res = true;
        boolean f = first == 't' ? true : false;
        switch (exp){
            case '!':
                res = !f;
                break;
            case '|' :
                res = f ;
                break;
            case '&' :
                res = f;
                break;
            default:
                throw new RuntimeException("unknown exp " + exp);
        }
        return res == true ? 't' : 'f';
    }

    private char parse(char exp, char first, char c) {
        boolean res = true;
        boolean f = first == 't' ? true : false;
        boolean s = c == 't' ? true : false;
        switch (exp){
            case '!':
                res = !f;
                break;
            case '|' :
                res = f || s;
                break;
            case '&' :
                res = f & s;
                break;
            default:
                throw new RuntimeException("unknown exp " + exp);
        }
        return res == true ? 't' : 'f';
    }
}
