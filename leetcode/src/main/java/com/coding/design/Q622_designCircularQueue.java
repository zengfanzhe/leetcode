package com.coding.design;

public class Q622_designCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        System.out.println(circularQueue.enQueue(1));  // return true
        System.out.println(circularQueue.enQueue(2));  // return true
        System.out.println(circularQueue.enQueue(3));  // return true
        System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
        System.out.println(circularQueue.Rear());  // return 3
        System.out.println(circularQueue.isFull());  // return true
        System.out.println(circularQueue.deQueue());  // return true
        System.out.println(circularQueue.enQueue(4));  // return true
        System.out.println(circularQueue.Rear());  // return 4
    }
}

class MyCircularQueue {

    int[] arr;
    int first, last;
    int capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.arr = new int[k+1];
        this.first = this.last = 0;
        this.capacity = k + 1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())
            return false;

        this.last = (this.last + 1)%this.capacity;
        this.arr[this.last] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
            return false;

        this.first = (this.first + 1)%this.capacity;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        return this.arr[(this.first + 1) % this.capacity];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
        return this.arr[this.last];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.first == this.last;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (this.last + 1)%this.capacity == this.first;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */