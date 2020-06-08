package com.coding.string;

import java.util.Stack;

public class Q227_basicCalculator2 {
    public static void main(String[] args) {
        Q227_basicCalculator2 q227 = new Q227_basicCalculator2();
        System.out.println(q227.calculate(" 3 + 2*2"));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int temp=0;
        char sign = '+';
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i)))
                temp = temp*10+s.charAt(i) - '0';

            if((s.charAt(i) != ' ' && !Character.isDigit(s.charAt(i))) || i == s.length()-1){
               switch (sign){
                   case '+' : stack.push(temp);break;
                   case '-' : stack.push(-temp); break;
                   case '*' : stack.push(stack.pop()*temp);break;
                   case '/' : stack.push(stack.pop()/temp);break;
                   default: throw new IllegalArgumentException("");
               }

               sign = s.charAt(i);
               temp = 0;
            }
        }
        int res=0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
