package com.lzz.learn.companies.shopee;

/**
 * @author LimLee
 * @data 2020-09-05
 *
 * 输出比当前数字小的最大值
 **/
public class Interview1 {
    public static void main(String[] args) {
        System.out.println(getSmaller("4321")); // 4312
        System.out.println(getSmaller("2211")); // 2121
        System.out.println(getSmaller("1122")); // 0
        System.out.println(getSmaller("211")); // 121
        System.out.println(getSmaller("99882211")); // 99882121
        System.out.println(getSmaller("103")); // 0
    }
    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
    private static void reverse(char[] chars, int i, int j) {
        while (j >= i) {
            swap(chars, i, j);
            i ++;
            j --;
        }
    }



    public static int getSmaller(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int i = n - 1;
        while (i > 0 && chars[i] >= chars[i - 1]) {
            i--;
        }
        // i - 1 是左边的值
        // 获取这个数，再获取小于他的最大数，再将剩下的排序
        if (i > 0 && chars[i] != chars[i - 1]) {
            int reverse = chars[i - 1] - '0';
            int j = n - 1;
            while (j >= i && chars[j] - '0' >= reverse) {
                j--;
            }
            // j 为需要交换的
            swap(chars, i - 1, j);
            reverse(chars, i, n - 1);
            if (chars[0] == '0') {
                return 0;
            }
            return Integer.valueOf(new String(chars));
        } else {
            return 0;
        }
    }
}
