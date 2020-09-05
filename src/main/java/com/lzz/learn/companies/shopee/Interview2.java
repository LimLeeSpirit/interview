package com.lzz.learn.companies.shopee;

/**
 * @author LimLee
 * @data 2020-09-05
 **/
public class Interview2 {
    public static void main(String[] args) {
        int[] woods = {-1, 4, 5, 2};
        System.out.println(ways(2, woods));
    }

    /**
     *
     * @param width  宽度
     * @param woods  中心坐标 和 宽度 [-1, 4, 5, 2]
     * @return
     */
    public static int ways(int width, int[] woods) {
        int n = woods.length;
        int ans = 1;
        for (int i = 0; i < n - 3; i += 2) {
            int dist = woods[i + 2] - woods[i] - woods[i + 1] / 2 - woods[i + 3] / 2;
            if (width < dist) {
                ans += 2;
            }
        }
        return ans + 1;
    }
}
