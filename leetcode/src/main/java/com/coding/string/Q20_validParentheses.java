package com.coding.string;

import java.util.Stack;

public class Q20_validParentheses {

    public static void main(String[] args) {
        Q20_validParentheses q20 = new Q20_validParentheses();
        System.out.println(q20.isValid("()[]{}"));
        System.out.println(q20.isValid("(]"));
        System.out.println(q20.isValid(""));
        System.out.println(q20.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (Character c : arr){
            if(stack.isEmpty()){
                stack.push(c);
            }else if(isSymmetrical(c, stack.peek())){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private boolean isSymmetrical(Character c, Character peek) {
        return (c == '}' && peek == '{' ||
                c == ')' && peek == '(' ||
                c == ']' && peek == '[');
    }
}
