package com.coding.stack;

import java.util.Stack;

public class Q331_verifyPreorderBT {
    public static void main(String[] args) {
        Q331_verifyPreorderBT q331 = new Q331_verifyPreorderBT();
        System.out.println(q331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(q331.isValidSerialization("1,#,#,1"));
        System.out.println(q331.isValidSerialization("#"));
    }

    public boolean isValidSerialization(String preorder) {
        if(preorder == null)
            return false;
        String[] strArr = preorder.split(",");
        if(strArr.length==0)
            return false;
        if (strArr.length==1 && strArr[0].equals("#"))
            return true;

        int index=0;
        Stack<String> stack = new Stack<>();
        stack.push(strArr[index++]);
        while(!stack.empty() && strArr.length > index){
            if(stack.peek().equals("#") && strArr[index].equals("#")){
               stack.pop();
               if(stack.empty())
                   return false;
               stack.pop();
            }else{
                stack.push(strArr[index++]);
            }
        }
        /**
         * 1: stack.empty() && strArr.length > index
         * 2: stack.empty() && strArr.length <= index
         * 3: !stack.empty() && strArr.length <= index
         */
        if(stack.empty() && index == strArr.length-1)
            return true;
        else
            return false;
    }
}
