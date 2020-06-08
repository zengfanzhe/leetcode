package com.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.min;

public class Main {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int temp = N;
        while(temp-->0){
            list.add((double)in.nextInt());
        }
        double res = func(N, M, list);
        System.out.println(String.format("%.2f", res));
    }

    private static double func(int n, int m, List<Double> list) {
        if(m == n)
            return min(list);
        if(m < n)
            return minMth(list, m);

        double max = getMaxAndRemove(list);
        double half = max/2;
        list.add(half);
        list.add(half);
        return func(n+2, m, list);


    }



    private static double getMaxAndRemove(List<Double> list) {
        double max = Double.MIN_VALUE;
        for(Double d: list ){
            if(d>max){
                max = d;
            }
        }
        list.remove(max);
        return max;
    }

    private static double minMth(List<Double> list, int m) {
        Collections.sort(list);
        return list.get(list.size()-m);
    }
}