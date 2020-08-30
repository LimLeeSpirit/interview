package com.lzz.learn.companies.tencent;

import java.util.*;

/**
 * @author LimLee
 * @data 2020-08-23
 * 找出前5小的子串
 **/
public class Interview5 {
    public static void main(String[] args) {
//        List<String> ss = Arrays.asList("b", "bb", "aabb", "aa", "a", "aab");
//        Collections.sort(ss);
//        for (String s : ss) {
//            System.out.println(s);
//        }
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        int k = in.nextInt();
//        in.close();
//        List<String> strs = new ArrayList<>();
//        Set<String> set = new HashSet<>();
//        int n = s.length();
//        for (int i = 0; i < n; i ++) {
//            for (int j = i + 1; j < n + 1; j ++) {
//                String cur = s.substring(i, j);
//                strs.remove(cur);
//                strs.add(cur);
////                if (!set.contains(cur)) {
////                    strs.add(cur);
////                    set.add(cur);
////                }
//            }
//        }
//
//        Collections.sort(strs);
//        for (String s1 : strs) {
//            System.out.println(s1);
//        }
//
//        System.out.println("ans:" + strs.get(k - 1));

        process();
    }

    public static void process() {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int k = in.nextInt();
        in.close();

        PriorityQueue<String> heap = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        Set<String> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n + 1; j ++) {
                String cur = s.substring(i, j);
                if (set.contains(cur)) continue;
                set.add(cur);
                heap.offer(cur);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
//        for (String ss : heap) {
//            System.out.printf(ss + " ");
//        }
//        System.out.println();
        System.out.println(heap.peek());
    }
}
