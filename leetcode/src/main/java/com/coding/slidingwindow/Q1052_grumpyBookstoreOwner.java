package com.coding.slidingwindow;

public class Q1052_grumpyBookstoreOwner {

    public static void main(String[] args) {
        //case 1:
        testCase(new int[]{0,1,0,0,10},
                 new int[]{0,1,0,0,0},
                 1, 11, "case 1");

        //case 2:
        testCase(new int[]{0,1,0,0,10},
                 new int[]{0,1,0,0,0},
                0, 10, "case 2");


        //case 3:
        testCase(new int[]{0,1,1,0,10},
                 new int[]{0,1,1,0,1},
                1, 10, "case 3");

        //case 4:
        testCase(new int[]{2,1,1,4,10},
                 new int[]{1,0,1,0,1},
                3, 16, "case 4");


        //case 5:
        testCase(new int[]{2,1,1,4,10},
                 new int[]{0,0,0,0,0},
                3, 18, "case 5");

        //case 6:
        testCase(new int[]{0,0,0,0,0},
                 new int[]{0,0,1,0,0},
                3, 0, "case 6");
    }

    private static void testCase(int[] customers, int[] grumpy, int X, int excepted, String name) {
        Q1052_grumpyBookstoreOwner q1052 = new Q1052_grumpyBookstoreOwner();
        if(excepted != q1052.maxSatisfied(customers, grumpy, X)){
            throw new RuntimeException(name);
        }
    }


    /**
     * approach 1
     */
    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        int result = 0;
        int max = 0;
        for(int i=0; i<customers.length; i++){
            if(grumpy[i] == 0){
                result += customers[i];
            }
        }

        for(int i=0; i<grumpy.length; i++){
            if(grumpy[i] == 1){
                int temp = 0;
                for (int j=i, count = 0; j<grumpy.length && count<X; j++, count++){
                    if(grumpy[j] == 1){
                        temp += customers[j];
                    }
                }
                max = max > temp ? max : temp;
            }
        }

        result += max;

        return result;
    }

    //approach 2
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max;
        int cur = 0;
        int low = 0;

        for(int i=0; i<customers.length; i++){
            if(grumpy[i] == 0)
                cur += customers[i];

            if(grumpy[i] == 1 && i<X)
                cur += customers[i];
        }

        max = cur;

        for(int high=X; high<customers.length; high++, low++){
            if(grumpy[low] == 1)
                cur -= customers[low];

            if (grumpy[high] == 1)
                cur += customers[high];

            max = cur > max ? cur : max;
        }

        return max;
    }
}
