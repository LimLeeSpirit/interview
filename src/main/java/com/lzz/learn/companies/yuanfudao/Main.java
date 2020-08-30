package com.lzz.learn.companies.yuanfudao;

import java.util.Scanner;

/**
 * @author LimLee
 * @data 2020-08-22
 *
 * 做游戏，理解错了题目意思
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(N);
        System.out.println(K);
        int cnt = process(N) - 1;
        if (cnt <= K) {
            System.out.println(0);
        } else {
            System.out.println(cnt - K);
        }
    }

    public static int process(int n) {
        if (n == 1) return 0;
        if (n == 2 || n == 3) return 2;
        if (n == 4) return 3;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        for (int i = 5; i <= n; i ++) {
            int t;
            // 奇数
            if ((i & 1) == 1) {
                t = (n >> 1) + 1;
            } else {
                t = n >> 1;
            }
            dp[i] = 1 + dp[n - t];
        }
        return dp[n];
    }
}
