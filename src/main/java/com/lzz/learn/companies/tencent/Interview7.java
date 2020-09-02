package com.lzz.learn.companies.tencent;

/**
 * @author LimLee
 * @data 2020-08-31
 *
 * 排序字符串，使用快排做的
 **/
public class Interview7 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        String[] strs = {"abc", "a", "bc"};
        sortStrs(strs);
        for (String s : strs) {
            System.out.println(s);
        }
    }

    public static void sortStrs(String[] strs) {
        // 无工具类 Collectios.sort(strs);
        partition(strs, 0, strs.length - 1);
    }

    private static void partition(String[] strs, int l, int r) {
        if (l >= r) return;
        // 标杆，取最右边字符串
        String flag = strs[r];
        int idx = l;
        for (int i = idx; i <= r; i ++) {
            boolean is_swap = check(strs, i, flag);
            if (is_swap) {
                //  交换
                swap(strs, idx, i);
                idx ++;
            }
        }
        swap(strs, idx, r);
        partition(strs, l, idx - 1);
        partition(strs, idx + 1, r);
    }

    private static boolean check(String[] strs, int i, String flag) {
        String curS = strs[i];
        int k = curS.length();
        int z = flag.length();
        // 比较两个字符串
        int j = 0;
        while (j < k && j < z) {
            int c1 = curS.charAt(j) - '0';
            int c2 = flag.charAt(j) - '0';
            if (c1 == c2) {
                j ++;
            } else if (c1 < c2) {
                return true;
            } else {
                return false;
            }
        }
        // 如果是第一个字符串走完了，但是第二个没走完，才返回true，才需要交换；否则，就是其他情况，比如两个字符串都走完了
        // 或者第一个没走完，只走完了第二个
        if (j >= k && j < z) {
            return true;
        } else {
            return false;
        }
    }

    private static void swap(String[] strs, int l, int r) {
        if (l >= r) return;
        String tmp = strs[l];
        strs[l] = strs[r];
        strs[r] = tmp;
    }
}