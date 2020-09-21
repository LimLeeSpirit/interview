package com.lzz.learn.companies.freewheel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author LimLee
 * @data 2020-09-19
 **/
public class Interview2 {
    public static void main(String[] args) {
        List<Integer> setA = Arrays.asList(1,2,3,3,4,4,5);
        List<Integer> setB = Arrays.asList(1,3,5,6,7);
        System.out.println(sortMergeJoin(new ArrayList<>(setA), new ArrayList<>(setB)));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 实现Sort Merge Join
     * @param setA int整型ArrayList
     * @param setB int整型ArrayList
     * @return int整型ArrayList<ArrayList<>>
     */
    public static ArrayList<ArrayList<Integer>> sortMergeJoin (ArrayList<Integer> setA, ArrayList<Integer> setB) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        List<List<Integer>> componets = new ArrayList<>();
        for (int i = 0; i < setA.size(); i ++) {
            List<Integer> tmp = Arrays.asList(setA.get(i), i, 1);
            componets.add(tmp);
        }

        for (int i = 0; i < setB.size(); i ++) {
            List<Integer> tmp = Arrays.asList(setB.get(i), i, 2);
            componets.add(tmp);
        }

        componets.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (!o1.get(0).equals(o2.get(0))) {
                    return o1.get(0).compareTo(o2.get(0));
                } else {
//                    if (!o1.get(1).equals(o2.get(1))) {
//                        return o1.get(1).compareTo(o2.get(1));
//                    } else {
//                        return o1.get(2).compareTo(o2.get(2));
//                    }
                    return o1.get(2).compareTo(o2.get(2));
                }
            }
        });

        int i = 0;
        int j = 0;
        while (i < componets.size()) {
            while (j < componets.size() && componets.get(j).get(0).equals(componets.get(i).get(0))) {
                j ++;
            }

            if (j > i + 1) {
                int k = j - 1;
                while (k > i && componets.get(k).get(0) == 2) {
                    k --;
                }
                for (int z = i; z < k + 1; z ++) {
                    for (int n = k + 1; n < j; n ++) {
                        List<Integer> tmp = Arrays.asList(componets.get(z).get(1), componets.get(n).get(1));
                        componets.add(tmp);
                    }
                }
            }
            i = j;
        }

        return ans;
    }
}
