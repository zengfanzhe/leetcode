package com.coding.concurrency;

import java.util.concurrent.Semaphore;

public class Q1115_printFooBarAlternately {
    public static void main(String[] args) {
        final FooBar fb = new Q1115_printFooBarAlternately().new FooBar(5);
        new Thread(){
            @Override
            public void run() {
                try {
                    fb.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    fb.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    //approach 1: semaphore
    class FooBar2 {
        private int n;
        Semaphore s0 = new Semaphore(0);
        Semaphore s1 = new Semaphore(1);

        public FooBar2(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                s1.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                s0.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                s0.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                s1.release();
            }
        }
    }


    //approach 2: producer-consumer
    class FooBar {
        private int n;
        private boolean printfoo = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this){
                    while(!printfoo)
                        wait();

                // printFoo.run() outputs "foo". Do not change or remove this line.
                     printFoo.run();
                     printfoo = false;
                     notify();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized(this) {
                    while (printfoo)
                        wait();

                // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    printfoo = true;
                    notify();
                }
            }
        }
    }
}
