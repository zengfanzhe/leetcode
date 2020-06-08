package com.coding.binarySearch;

public class Q29_divideTwoInteger {
    public static void main(String[] args) {
        Q29_divideTwoInteger q29 = new Q29_divideTwoInteger();
        /*System.out.println(q29.divide(9,-3));
        System.out.println(q29.divide(0,3));
        System.out.println(q29.divide(1,1));
        System.out.println(q29.divide(Integer.MIN_VALUE,-1));
        System.out.println(q29.divide(Integer.MAX_VALUE,2));
        System.out.println(q29.divide(11,3));
        System.out.println(Integer.MAX_VALUE/2);*/

        System.out.println(q29.divide(Integer.MIN_VALUE,-2));
        System.out.println(Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE);

    }

    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dvd = dividend, dvs = divisor; // Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE
        dvd = Math.abs(dvd);
        dvs = Math.abs(dvs);
        int result = 0;

        while(dvd >= dvs){
            long temp = dvs;
            int n=1;
            while(dvd >= (temp<<1)){
                n<<=1;
                temp<<=1;
            }
            dvd-=temp;
            result+=n;
        }
        return sign*result;
    }
}
