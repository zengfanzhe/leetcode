package com.coding.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
//import java.util.function.IntConsumer;

public class Q1116_printZeroEvenOdd {
    /*public static void main(String[] args) {
        ZeroEvenOdd2 zeroEvenOdd2 = new Q1116_printZeroEvenOdd().new ZeroEvenOdd2(6);
        new Thread(){
            @Override
            public void run() {
                try {
                    zeroEvenOdd2.zero(new Q1116_printZeroEvenOdd().new IntConsumerImpl());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    zeroEvenOdd2.even(new Q1116_printZeroEvenOdd().new IntConsumerImpl());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    zeroEvenOdd2.odd(new Q1116_printZeroEvenOdd().new IntConsumerImpl());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    class ZeroEvenOdd2 {
        private int n;
        private volatile int flag = 0;
        private volatile int num = 1;
        public ZeroEvenOdd2(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
            while (num <= n){
                while (flag != 0)
                    wait();

                if(num <= n) {
                    printNumber.accept(0);
                    flag = num % 2 == 0 ? 2 : 1;
                    notifyAll();
                }else {
                    flag = n%2 == 0 ? 1 : 2;//it is the point
                    notifyAll();
                }
            }
        }

        public synchronized void even(IntConsumer printNumber) throws InterruptedException {
            while (num <= n){
                while(flag != 2)
                    wait();

                if(num <= n) {
                    printNumber.accept(num++);
                    flag = 0;
                    notifyAll();
                }else{
                    notifyAll();
                }
            }
        }

        public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
            while (num <= n){
                while(flag != 1)
                    wait();

                if(num <= n) {
                    printNumber.accept(num++);
                    flag = 0;
                    notifyAll();
                }else{
                    notifyAll();
                }
            }
        }
    }


    class ZeroEvenOdd1 {
        private int n;
        private volatile int flag = 0;
        public ZeroEvenOdd1(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public synchronized void zero(IntConsumer printNumber) throws InterruptedException {

               for(int i=1; i<=n; i++){
                   while (flag != 0)
                       wait();

                   printNumber.accept(0);
                   flag = i%2 == 0 ? 2 : 1;
                   notifyAll();
               }

        }

        public synchronized void even(IntConsumer printNumber) throws InterruptedException {
                for(int i=2; i<=n; i+=2){
                    while (flag != 2)
                        wait();

                    printNumber.accept(i);
                    flag = 0;
                    notifyAll();
                }
        }

        public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
                for(int i=1; i<=n; i+=2){
                    while (flag != 1)
                        wait();

                    printNumber.accept(i);
                    flag = 0;
                    notifyAll();
                }
        }
    }


    class ZeroEvenOdd {
        private int n;
        private Semaphore szero = new Semaphore(1);
        private Semaphore sodd = new Semaphore(0);
        private Semaphore seven = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i=1; i<=n; i++){
                szero.acquire();
                printNumber.accept(0);
                if (i%2 == 0){
                    seven.release();
                }else{
                    sodd.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i=2; i<=n; i+=2){
                seven.acquire();
                printNumber.accept(i);
                szero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i=1; i<=n; i+=2){
                sodd.acquire();
                printNumber.accept(i);
                szero.release();
            }
        }
    }

    class IntConsumerImpl implements IntConsumer{

        @Override
        public void accept(int value) {
            System.out.print(value);
        }
    }
*/}
