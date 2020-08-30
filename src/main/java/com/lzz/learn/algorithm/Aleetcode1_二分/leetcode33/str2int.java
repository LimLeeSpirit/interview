package com.lzz.learn.algorithm.Aleetcode1_二分.leetcode33;

/**
 * @author LimLee
 * @data 2020-08-22
 **/
public class str2int {
    public static void main(String[] args) {
        System.out.println("dewre3234");
        System.out.println('j' -'0');
    }

    public static int str2int(String s) {
        int ans = 0;
        int n = s.length();
        int i = 0;
        while (i < n && ((s.charAt(i) - '0') < 0 || (s.charAt(i) - '0') > 9)) {
            i ++;
        }
        boolean is_minus = false;
        if ((i - 1 >= 0) && s.charAt(i) == '-') {
            is_minus = true;
        }
        while (i < n) {
            int cur = s.charAt(i) - '0';
            ans = ans * 10 + cur;
            i ++;
        }
        if (is_minus) {
            return -1 * ans;
        }
        return ans;
    }
}
