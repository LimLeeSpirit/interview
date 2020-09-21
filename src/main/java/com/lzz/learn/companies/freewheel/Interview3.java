package com.lzz.learn.companies.freewheel;

import java.util.Scanner;

/**
 * @author LimLee
 * @data 2020-09-20
 *
 * 1
 * 3 4
 * ####
 * #@.*
 * **.*
 **/
public class Interview3 {
    public static int[][] record;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scan.nextInt(), M = scan.nextInt();
            char[][] cs = new char[N][M];
            int x = 0, y = 0;
            record = new int[N][M];

            for (int p = 0; p < N; p++) {
                String str = scan.next();
                for (int q = 0; q < M; q++) {
                    cs[p][q] = str.charAt(q);
                    if (str.charAt(q) == '@') {
                        x = p;
                        y = q;
                    }
                    record[p][q] = Integer.MAX_VALUE;
                }
            }
            int res = solution(cs, x, y);
            res = (res == Integer.MAX_VALUE) ? -1 : res;
            System.out.println(res);
        }
    }

    public static int solution(char[][] cs, int x, int y) {
        if (x < 0 || x >= cs.length || y < 0 || y >= cs[0].length) {
            return 0;
        }
        if (cs[x][y] == '#') {
            return Integer.MAX_VALUE;
        }
        if (record[x][y] != Integer.MAX_VALUE) {
            return record[x][y];
        }
        int res = Integer.MAX_VALUE;
        char temp = cs[x][y];
        cs[x][y] = '#';
        int s1 = solution(cs, x - 1, y);
        int s2 = solution(cs, x + 1, y);
        int s3 = solution(cs, x, y - 1);
        int s4 = solution(cs, x, y + 1);
        cs[x][y] = temp;
        res = Math.min(Math.min(Math.min(Math.min(s1, s2), s3), s4), res);
        if (res == Integer.MAX_VALUE) {
            return res;
        }
        if (temp == '*') res ++;
        record[x][y] = res;
        return res;
    }

}