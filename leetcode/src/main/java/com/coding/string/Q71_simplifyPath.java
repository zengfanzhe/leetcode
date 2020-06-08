package com.coding.string;

import java.util.Stack;

public class Q71_simplifyPath {
    public static void main(String[] args) {
        Q71_simplifyPath q71 = new Q71_simplifyPath();
        System.out.println(q71.simplifyPath("/home/"));
        System.out.println(q71.simplifyPath("/../"));
        System.out.println(q71.simplifyPath("/home//foo/"));
        System.out.println(q71.simplifyPath("/a/./b/../../c/"));
        System.out.println(q71.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(q71.simplifyPath("/"));
    }
    public String simplifyPath(String path) {
        if(path == null)
            throw new IllegalArgumentException();

        Stack<String> stack = new Stack<>();
        String res="";
        for(String s : path.split("/")){
            if("".equals(s) || ".".equals(s))
                continue;
            if("..".equals(s)){
                if(!stack.empty())
                    stack.pop();
            } else {
                stack.push("/" + s);
            }
        }
        if(stack.empty())
            res = "/";
        else{
            while(!stack.empty()){
                res = stack.pop() + res;
            }
        }
        return res;
    }
}
