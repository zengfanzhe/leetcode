package com.coding.stack;

import java.util.Stack;

public class Q224_basicCalculator {
    public static void main(String[] args) {
        Q224_basicCalculator q224 = new Q224_basicCalculator();
        System.out.println(q224.calculate("1 + 1"));
        System.out.println(q224.calculate(" 2-1 + 2 "));
        System.out.println(q224.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(q224.calculate(" 20-10 + 2 "));
    }

    public int calculate(String s) {
        int op = 0; // operation
        int sign = 1; //1:positive; -1:negative
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                op = op * 10 + (ch - '0');
            }else if(ch == '+'){
                result += op * sign;
                sign = 1;
                op = 0;
            }else if(ch == '-'){
                result += op * sign;
                sign = -1;
                op = 0;
            }else if(ch == '('){
                stack.push(result);
                stack.push(sign);

                sign = 1;
                result = 0;
            }else if(ch == ')'){
                result += op * sign;

                result *= stack.pop();

                result += stack.pop();

                op = 0;
            }
        }

        result += op * sign;
        return result;
    }
}
