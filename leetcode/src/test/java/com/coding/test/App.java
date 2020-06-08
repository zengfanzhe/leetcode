package com.coding.test;

public class App {
    private int value;

    public App(){
        this.value = 0;
    }

    public synchronized int getValue(){
        System.out.println("我是 " + Thread.currentThread() + " get");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }

    public synchronized void addOne(){
        System.out.println("我是 " + Thread.currentThread() + " addOne");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value++;
    }

    public static void main(String[] args) {
        final App app = new App();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(app.getValue());
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    app.addOne();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    app.addOne();
                }
            }
        });


        t2.start();
        t3.start();
        System.out.println("t2, t3 is start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.start();
        System.out.println("t1 is start");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");

    }
}
