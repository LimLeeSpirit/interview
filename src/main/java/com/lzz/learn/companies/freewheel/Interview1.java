package com.lzz.learn.companies.freewheel;

import java.util.*;

/**
 * @author LimLee
 * @data 2020-09-19
 **/
public class Interview1 {
    public static void main(String[] args) {
        List<Integer> t = Arrays.asList(1,3,5);
        for (int a : t) {
            System.out.println(a);
        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 对输入集合做hash join，输出关联后的下标的二元组集合
     * @param setA int整型ArrayList 输入集合1
     * @param setB int整型ArrayList 输入集合2
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> hashJoin (ArrayList<Integer> setA, ArrayList<Integer> setB) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> flagList = setB;
        ArrayList<Integer> longList = setA;
        if (setA.size() < setB.size()) {
            flagList = setA;
            longList = setB;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < flagList.size(); i ++) {
            if (!map.containsKey(flagList.get(i))) {
                List<Integer> cur = new ArrayList<>();
                cur.add(i);
                map.put(flagList.get(i), cur);
            } else {
                map.get(flagList.get(i)).add(i);
            }
        }
        for (int j = 0; j < longList.size(); j ++) {
            if (map.containsKey(longList.get(j))) {
                for (int k : map.get(longList.get(j))) {
                    List<Integer> tmp = Arrays.asList(k, j);
                    ans.add(new ArrayList<>(tmp));
                }
            }
        }
        return ans;
    }
}
