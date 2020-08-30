package com.lzz.learn.companies.kuaishou;


/**
 * @author LimLee
 * @data 2020-08-22
 **/
public class Sprt {
    public static void main(String[] args) {
        System.out.println(sprt(9));
    }
    public static int sprt(int a) {
        if (a < 0) return -1;
        int l = 0;
        int r = a >> 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (a / mid < mid) {
                r = mid;
            } else {
                l ++;
            }
        }
        return l * l <= a ? l : l - 1;
    }
}
