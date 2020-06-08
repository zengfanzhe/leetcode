package com.coding.string;

public class Q12_integerToRoman {
    public static void main(String[] args) {
        Q12_integerToRoman q12 = new Q12_integerToRoman();
        System.out.println(q12.intToRoman(5));
        System.out.println(q12.intToRoman(9));
        System.out.println(q12.intToRoman(58));
        System.out.println(q12.intToRoman(1994));

    }

/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000


    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

 */

//approach 1:
    public String intToRoman2(int num) {
        StringBuffer strBuf = new StringBuffer();
        while(num > 0){
            if(num >= 1000){
                strBuf.append('M');
                num -= 1000;
            }else if(num >= 900){
                strBuf.append("CM");
                num -= 900;
            } else if(num >= 500){
                strBuf.append('D');
                num -= 500;
            }else if(num >= 400){
                strBuf.append("CD");
                num -= 400;
            }else if(num >= 100){
                strBuf.append('C');
                num -= 100;
            }else if(num >= 90){
                strBuf.append("XC");
                num -= 90;
            }else if(num >= 50){
                strBuf.append('L');
                num -= 50;
            }else if(num >= 40){
                strBuf.append("XL");
                num -= 40;
            }else if(num >= 10){
                strBuf.append('X');
                num -= 10;
            }else if(num >= 9){
                strBuf.append("IX");
                num -= 9;
            }else if(num >= 5){
                strBuf.append('V');
                num -= 5;
            }else if(num >= 4){
                strBuf.append("IV");
                num -= 4;
            }else {
                strBuf.append('I');
                num -= 1;
            }
        }
        return strBuf.toString();
    }

    //approach 2:
    public String intToRoman(int num) {
        int[] nums= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<nums.length;i++) {
            while(num>=nums[i]) {
                sb.append(romans[i]);
                num-=nums[i];
            }
        }
        return sb.toString();
    }
}
