package com.coding.random;

public class Q470_implementRand10 {

    public static void main(String[] args) throws Exception{
        Q470_implementRand10 q470 = new Q470_implementRand10();
        while(true){
            System.out.println(q470.rand10());

            Thread.sleep(100);
        }
    }

    public int rand7(){
        return (int)(Math.random()*7 + 1);
    }

    public int rand10() {
        int result;
        do {
            int row = rand7();
            int col = rand7();

            result = col + (row - 1) * 7;
        } while(result > 40);

        return 1 + (result - 1) % 10;
    }
}
