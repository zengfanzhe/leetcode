package com.coding;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.Stack;

/**
 * Hello world!
 */
public class App {
    /**
     * Ctrl+H，显示类结构图（类的继承层次）
     * Ctrl+/或Ctrl+Shift+/，注释
     * Shift+F6，重构 – 重命名 or Shift+R
     * Ctrl+X，删除行
     * Ctrl+D，复制行
     * Alt+Insert，可以生成构造器/Getter/Setter等
     * Ctrl+Alt+L，格式化代码
     * Ctrl+Alt+Space，类名自动完成
     * Ctrl+Shift+Alt+N，查找类中的方法或变量
     * Alt+Enter, 智能提示
     * Alt+/, 补全
     * Alt+7,查看类的方法和属性
     * Ctrl+Shift+Up/Down,向上/下移动语句
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<5; i++){
            stack.push(i);
        }
        printStack(stack);
        reverse(stack);
        printStack(stack);

        //reverse(null);
    }

    private static void printStack(Stack<Integer> stack) {
        for (Integer elem : stack){
            System.out.print(elem + " ");
        }
        System.out.println();
    }


    public static void reverse(Stack<Integer> stack) {
        if(stack == null)
            throw new IllegalArgumentException("stack can't be null.");
        if(stack.size()<=1)
            return;
       int element = removeAndGetLastElement(stack);
       reverse(stack);
       stack.push(element);
    }

    private static int removeAndGetLastElement(Stack<Integer> stack) {
        if (stack == null || stack.empty())
            throw new IllegalArgumentException("stack is null or empty.");

        int elem = stack.pop();
        if(stack.empty())
            return elem;
        int last = removeAndGetLastElement(stack);
        stack.push(elem);
        return last;
    }


}