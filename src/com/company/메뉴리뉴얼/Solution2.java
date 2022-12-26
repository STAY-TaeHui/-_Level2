package com.company.메뉴리뉴얼;
//Solution 클래스를 본 후에 코딩

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        solution(new String[]{"XYZ", "XWY", "WXA"},new int[]{2,3,4});
    }
    public static ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for(int i=0; i<orders.length; i++){
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }

        for(int i=0; i<course.length; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < orders.length; j++) {
                if (course[i] <= orders[j].length()) {
                    combi(orders[i], )

                }
            }
        }
        return answer;
    }
}
