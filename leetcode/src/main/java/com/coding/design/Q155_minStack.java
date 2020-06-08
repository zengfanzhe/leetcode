package com.coding.design;

public class Q155_minStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }
}

class MinStack {

    Node current;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(current == null){
            current = new Node(x, x, null);
        }else{
            current = new Node(x, x < current.min ? x : current.min, current);
        }
    }

    public void pop() {
        current = current.next;
    }

    public int top() {
        return current.data;
    }

    public int getMin() {
        return current.min;
    }

    class Node {
        Integer data;
        Integer min;
        Node next;

        public Node(Integer data, Integer min, Node next){
            this.data = data;
            this.min = min;
            this.next = next;
        }
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */