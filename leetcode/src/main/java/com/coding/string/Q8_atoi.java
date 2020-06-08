package com.coding.string;

public class Q8_atoi {
    public static void main(String[] args) {
        Q8_atoi Q8 = new Q8_atoi();
        System.out.println(Q8.myAtoi("-42"));
        System.out.println(Q8.myAtoi("+41"));
        System.out.println(Q8.myAtoi(" 41"));
        System.out.println(Q8.myAtoi("4193 with words"));
        System.out.println(Q8.myAtoi("words and 987"));
        System.out.println(Q8.myAtoi("123456789023"));
        System.out.println(Q8.myAtoi("-123456789023"));
        System.out.println(Q8.myAtoi(""));
        System.out.println(Q8.myAtoi(null));
        System.out.println(Q8.myAtoi("          "));

    }
    public int myAtoi(String str) {
        if(str==null)
            return 0;
        String s = str.trim();
        if(s.length()==0)
            return 0;
        int sign=1,index=0;
        long result=0;
        if(s.charAt(0)=='+' || s.charAt(0)=='-') {
            sign=s.charAt(0)=='+'?1:-1;
            index++;
        }
        while(index<s.length()){
            if(!Character.isDigit(s.charAt(index)))
                return (int)(sign*result);
            result=result*10+(s.charAt(index)-'0');
            if(sign==1 && result>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sign==-1 && -result<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            index++;
        }
        return (int)(sign*result);
    }
}
