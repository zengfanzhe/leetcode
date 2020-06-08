package com.coding.concurrency;

import java.util.concurrent.Semaphore;

public class Q1114_printInOrder {

    public static void main(String[] args) throws InterruptedException {
       final Foo f1 = new Q1114_printInOrder().new Foo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f1.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("second");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f1.third(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("third");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f1.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("first");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }



    class Foo {

        Semaphore run2;
        Semaphore run3;

        public Foo() {
            run2 = new Semaphore(0);
            run3 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            run2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            run2.acquire();
            printSecond.run();
            run3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            run3.acquire();
            printThird.run();
        }
    }
}
