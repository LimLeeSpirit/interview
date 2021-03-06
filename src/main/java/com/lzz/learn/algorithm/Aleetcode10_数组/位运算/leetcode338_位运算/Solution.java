package com.lzz.learn.algorithm.Aleetcode10_数组.位运算.leetcode338_位运算;

/**
 *  统计从 0 到 num 的数字各自有多少个二进制位为 1 的个数,返回数组
 *
 *  输入: 5, 0,1,2,3,4,5
 *  输出:   [0,1,1,2,1,2]
 *
 *  基本思想：先想一下其中一个数字是否怎么计算 1 的位数，这不就是汉明距离吗，然后对每一个数字进行计算其二进制位 1 的个数
 *  终极思想：为什么要返回数组呢？计算每个数字的，应该是可以有巧方法？对了，就是利用递推公式
 */
public class Solution {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        ret[0] = 0;
        for (int i = 1; i <= num; i ++) {
            // 任何一个数的二进制位1数 总是等于把这个数的最右边的第一个1去掉后的这个数的二进制位数1的总数 + 1
            // 去掉 i 的最右边的 1，i = i&(i-1);
            ret[i] = ret[i & (i - 1)] + 1;
        }
        return ret;
    }
}
