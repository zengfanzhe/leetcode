package com.coding.greedy;


public class Q402_removeKDigits {
    public static void main(String[] args) {
        Q402_removeKDigits q402_removeKDigits = new Q402_removeKDigits();
        System.out.println(q402_removeKDigits.removeKdigits("1432219",3));
        System.out.println(q402_removeKDigits.removeKdigits("10200",3));
        System.out.println(q402_removeKDigits.removeKdigits("1",3));
    }

    public String removeKdigits(String num, int k) {
        StringBuffer buffer = new StringBuffer(num);
        while(k>0 && buffer.length()>0){
            for(int i=0; i<buffer.length(); i++){
                if(i == buffer.length()-1){
                    buffer.deleteCharAt(i);
                    k--;
                    break;
                }

                if(buffer.charAt(i) > buffer.charAt(i+1)){
                    buffer.deleteCharAt(i);
                    k--;
                    break;
                }
            }
            while(buffer.length()>0){
                if(buffer.charAt(0) == '0')
                    buffer.deleteCharAt(0);
                else
                    break;
            }
        }
        return "".equals(buffer.toString())?"0":buffer.toString();
    }
}
