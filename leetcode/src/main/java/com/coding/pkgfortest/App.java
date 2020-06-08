package com.coding.pkgfortest;

public class App {
    static final StringBuffer buffer = new StringBuffer();
    static final String str = new String("hello");
    public static void main(String[] args) {
        StringBuffer temp = App.buffer;
        String str = App.str;
        System.out.println(App.buffer);
        App.buffer.append(0);
        System.out.println(App.buffer == temp);
        System.out.println("*************");

    }
}
