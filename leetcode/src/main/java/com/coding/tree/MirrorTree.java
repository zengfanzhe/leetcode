package com.coding.tree;

public class MirrorTree {

    public static void main(String[] args) {
        MirrorTree m = new MirrorTree();
        String s = m.firstAlphabet("a s a sdsf g asdas ");
        System.out.println(s);
    }


    public static String reverseWord(String str)
    {
        char[] arr = str.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<j){
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
        return new String(arr);
    }

    String firstAlphabet(String S) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        char[] arr = S.toCharArray();
        for (char c : arr){
            if (c == ' '){
                i=0;
            }else{
                ++i;
                if (i == 1){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

}


