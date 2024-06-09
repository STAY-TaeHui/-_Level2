package com.company.스킬체크.Level2;

import java.util.Arrays;

public class Level2 {
    public int solution(int n) {
        int next = n;

        StringBuilder sb = toBinaryString(n);
        long countN = count1(sb.toString());

        while (true) {
            next += 1;
            StringBuilder sb2 = toBinaryString(next);
            long countNext = count1(sb2.toString());

            if (countN == countNext) {
                break;
            }
        }
        return next;
    }
    private long count1(String s){
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
    private StringBuilder toBinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n%2);
            n = n/2;
        }
        return sb;
    }

}
