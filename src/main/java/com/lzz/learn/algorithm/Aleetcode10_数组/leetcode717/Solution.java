package com.lzz.learn.algorithm.Aleetcode10_数组.leetcode717;

/**
 * 有两种特殊字符。第一种字符可以用一比特 0 来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个 1 比特字符。给定的字符串总是由 0 结束。
 * 就只有三种编码方式：0、 10、 11，遇到1，必定跳2位，遇到 0， 必定跳 1 位。也就是线性搜索了
 *
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 *
 * 这个题还是很精巧的，
 */
public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        // 在倒数第二个字符的时候，判断其下一步会跳到哪里，如果是跳到最后一个字符，说明就是以一比特结尾
        // 如果不是，比如跳到最后一个字符的下一个字符，则说明不是以一比特结尾。
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}
