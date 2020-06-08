package com.coding.string;

public class Q67_addBinary {
    public static void main(String[] args) {
       Q67_addBinary q67 = new Q67_addBinary();
        System.out.println(q67.addBinary("1","11"));
        System.out.println(q67.addBinary("1010","1011"));
        System.out.println(q67.addBinary("1","1"));
        System.out.println(q67.addBinary("0","0"));
        System.out.println(q67.addBinary("0","11"));
    }

    public String addBinary(String a, String b) {
        int carry = 0;
        int ai = a.length()-1, bi = b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(ai >=0 || bi >= 0){
            int sum = carry;
            if(ai>=0) sum+=a.charAt(ai--)-'0';
            if(bi>=0) sum+=b.charAt(bi--)-'0';
            carry = sum/2;
            sb.append(sum%2);
        }
        if(carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
