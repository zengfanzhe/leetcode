package com.coding.array;

public class Q551_studentAttendanceRecordI {

    public static void main(String[] args) {
        Q551_studentAttendanceRecordI q551 = new Q551_studentAttendanceRecordI();
        System.out.println(q551.checkRecord("PPALLP"));
        System.out.println(q551.checkRecord("PPALLL"));
        System.out.println(q551.checkRecord("PPALLPL"));
        System.out.println(q551.checkRecord("PPALLPLLLP"));
    }

    public boolean checkRecord(String s) {
        int a=0;
        int l=0;

        char[] arr = s.toCharArray();

        for (int i=0; i<arr.length; i++){
            if (arr[i] == 'A'){
                ++a;
            }

            if(arr[i] == 'L'){
                ++l;
            }else {
                l=0;
            }

            if(a > 1 || l > 2)
                return false;
        }
        return true;
    }

}
