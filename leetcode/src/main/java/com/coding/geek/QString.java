package com.coding.geek;

import java.util.ArrayList;
import java.util.List;

public class QString {

    public static void main(String[] args) {
        QString q = new QString();
        List<String> res = splitString("abcdef");
        for (String s : res){
            System.out.println(s);
        }
    }

    /**
     * Split Strings
     */
    static List<String> splitString(String S) {
        ArrayList<String> list = new ArrayList<>(3);
        StringBuffer alp = new StringBuffer();
        StringBuffer num = new StringBuffer();
        StringBuffer other = new StringBuffer();

        char[] arr = S.toCharArray();
        for (char c : arr){
            if ((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')){
                alp.append(c);
            }else if(c >= '0' && c<='9'){
                num.append(c);
            }else{
                other.append(c);
            }
        }
        if (alp.length() != 0){
            list.add(alp.toString());
        }else{
            list.add("-1");
        }


        if (num.length() != 0){
            list.add(num.toString());
        }else{
            list.add("-1");
        }


        if (other.length() != 0){
            list.add(other.toString());
        }else{
            list.add("-1");
        }

        return list;
    }


}
