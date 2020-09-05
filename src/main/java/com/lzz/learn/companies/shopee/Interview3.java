package com.lzz.learn.companies.shopee;

import com.sun.tools.javac.comp.Check;

import java.util.Arrays;

/**
 * @author LimLee
 * @data 2020-09-05
 * 换奖品
 **/
public class Interview3 {
    public static void main(String[] args) {
        int[] nums1 = {4, 4, 2}; // 2
        int[] nums2 = {9, 3, 3}; // 4
        System.out.println(numOfPrice(nums1));
        System.out.println(numOfPrice(nums2));
    }

    public static int numOfPrice(int[] nums) {
        Arrays.sort(nums);
        int min_n = nums[0];
        for (int i = 0; i < 3; i ++) {
            nums[i] -= min_n;
        }
        return min_n + dfs(nums);
    }

    private static int dfs(int[] nums) {
        int check_zero = check_zero(nums);
        if (check_zero == 1) {
            if (nums[2] <= 2) return 0;
            else {
                nums[1] -= 1;
                nums[2] -= 2;
                return 1 + dfs(nums);
            }
            // 2 个 0
        } else {
            return nums[2] / 5;
        }
    }

    private static int check_zero(int[] nums) {
        int ans = 0;
        for (int a : nums) {
            if (a == 0) ans ++;
        }
        return ans;
    }
}
