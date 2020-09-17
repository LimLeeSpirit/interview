package com.lzz.learn.companies.dianxinyun;

import java.util.Scanner;

/**
 * @author LimLee
 * @data 2020-09-16
 **/
public class Interview1 {
    public static void main(String[] args) {
        System.out.println(ugly(1));
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int i = 1;
        while(N > 0) {
            if (ugly(i)) {
                N --;
            }
            i ++;
        }
        System.out.println(-- i);
    }
    private static boolean ugly(int i) {
        while ((i % 2) == 0) {
            i /= 2;
        }
        while ((i % 3) == 0) {
            i /= 3;
        }
        while ((i % 5) == 0) {
            i /= 5;
        }
        return i == 1;
    }
}
