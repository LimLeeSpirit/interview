package com.lzz.learn.companies.dianxinyun;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author LimLee
 * @data 2020-09-16
 **/
public class Interview2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            cnt[idx] ++;
        }

        int min_cnt = 0;
        for (int i = 0; i < 26; i ++) {
            if (cnt[i] > 0) {
                min_cnt = cnt[i];
                break;
            }
        }
        for (int k = 0; k < 26; k ++) {
            if (cnt[k] > 0 && cnt[k] < min_cnt) {
                min_cnt = cnt[k];
            }
        }

        Set<Integer> min_set = new HashSet<>();
        for (int j = 0; j < 26; j ++) {
            if (cnt[j] == min_cnt) {
                min_set.add(j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (!min_set.contains(idx)) {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}

