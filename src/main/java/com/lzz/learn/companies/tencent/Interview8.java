package com.lzz.learn.companies.tencent;


import java.util.*;

/**
 * @author LimLee
 * @data 2020-09-06
 **/
public class Interview8 {
    public static int[] used;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nums = in.nextInt();
        System.out.println("nums:" + nums);
        int groups = in.nextInt();
        System.out.println("groups:" + groups);
        used = new int[groups];
        List<Set<Integer>> idxs = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < groups; i ++) {
            Set<Integer> cur = new HashSet<>();
            // 将一行分割，前一个为大小，后面的为编号
            String[] cur_group = in.nextLine().trim().split(" ");
            System.out.println("cur group:" + cur_group[0]);
            for (int j = 0; j < Integer.valueOf(cur_group[0]); j ++) {
                int curIdx = Integer.valueOf(cur_group[j + 1]);
                cur.add(curIdx);
            }
            if (cur.contains(0)) {
                used[i] = 1;
                zeros.add(i);
            }
            idxs.add(cur);
            for (int a : cur) {
                System.out.println(a);
            }
        }
        int ans = 0;
        for (int k = 0; k < zeros.size(); k ++) {
            int curIdx = zeros.get(k);
            ans += idxs.get(curIdx).size();
            // 遍历集合，查找有相同元素的
            ans += check(idxs, curIdx);
        }
        System.out.println(ans);
    }

    private static int check(List<Set<Integer>> idxs, int k) {
        int ans = 0;
        for (int a : idxs.get(k)) {
            for (int i = 0; i < idxs.size(); i ++) {
                if (used[i] != 1 && idxs.get(i).contains(a)) {
                    ans += idxs.get(i).size();
                    used[i] = 1;
                }
            }
        }
        return ans;
    }
}
