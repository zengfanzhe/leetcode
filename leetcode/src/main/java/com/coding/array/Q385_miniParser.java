package com.coding.array;

import java.util.List;
import java.util.Stack;

public class Q385_miniParser {
    public static void main(String[] args) {

    }

    public NestedInteger deserialize(String s) {
        if(s.length() > 0 && s.charAt(0) != '['){
            return new NestedInteger(Integer.valueOf(s));
        }

        NestedInteger root = null;
        char[] arr = s.toCharArray();
        Stack<NestedInteger> stack = new Stack<>();
        int num = 0, flag = 1;
        boolean isNum = false;
        for(Character c : arr){
            if(c == '['){
                if(stack.isEmpty()){
                    stack.push(new NestedInteger());
                }else {
                    NestedInteger ni = new NestedInteger();
                    stack.peek().add(ni);
                    stack.push(ni);
                }
            }else if(c == ',' || c == ']'){
                if(isNum){
                    stack.peek().add(new NestedInteger(flag * num));
                    isNum = false;
                    flag = 1;
                    num = 0;
                }
                if(c == ']'){
                    root = stack.pop();
                }
            }else if(c == '-'){
                isNum = true;
                flag = -1;
            }else {
                isNum = true;
                num = num * 10 + (c - '0');
            }
        }
        return root;
    }



}


// This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
class NestedInteger {
      // Constructor initializes an empty nested list.
      public NestedInteger(){}

     // Constructor initializes a single integer.
      public NestedInteger(int value){return;}

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger(){return false;}

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger(){return 0;}

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value){}

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni){}

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList(){return null;}
}

