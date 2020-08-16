package com.lzz.learn.algorithm.A_排序;

import java.text.DecimalFormat;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(pow(3, 4));
    }
    public static String pow(int x, int n) {
        DecimalFormat df = new DecimalFormat(".00");
        boolean is_minus = false;
        if (n < 0) {
            n = Math.abs(n);
            is_minus = true;
        }

        if (is_minus) {
            return df.format(1d / process(x, n));
        } else {
            return df.format(process(x, n));
        }
    }

    public static double process(int x, int n) {
        if (n == 1) {
            return x;
        }
        // 奇数
        if ((n & 1) == 1) {
            return x * process(x, n >> 1) * process(x, n >> 1);
        } else {
            return process(x, n >> 1) * process(x, n >> 1);
        }
    }
}
