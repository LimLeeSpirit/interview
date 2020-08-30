package com.lzz.learn.companies.tencent;

import java.util.Scanner;

/**
 * @author LimLee
 * @data 2020-08-23
 **/
public class Interview6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int max_num = 0;
        for (int i = 0; i < n; i ++) {
            nums[i] = in.nextInt();
            if (nums[i] > max_num) {
                max_num = nums[i];
            }
        }
        System.out.println("max :" + max_num);
        int ans = 0;
        for (int i = 1; i <= max_num; i ++) {
            int top = 0;
            int bottom = n - 1;
            while (nums[top] < i) top ++;
            while (nums[bottom] < i) bottom --;
            for (int j = top; j <= bottom; j ++) {
                if (nums[j] < i) {
                    ans ++;
                }
            }
            ans ++;
        }
        System.out.println(Math.min(n, ans));

    }

}
