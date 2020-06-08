package com.coding.binarySearch;

public class Q69_sqrt {
    public static void main(String[] args) {
        Q69_sqrt q69 = new Q69_sqrt();
        System.out.println(q69.mySqrt(8));
        System.out.println(q69.mySqrt(4));
        System.out.println(q69.mySqrt(1));
        System.out.println(q69.mySqrt(0));
        System.out.println(q69.mySqrt(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        int low=1,high=x,result=-1;
        while(high>=low){
            int mid = (high-low)/2 + low;
            if(mid == x/mid){
                result=mid;
                break;
            }else if(mid < x/mid){
                result = mid;
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return result;
    }
}
