package com.company.메뉴리뉴얼;
//Solution 클래스를 본 후에 코딩

import java.util.*;

public class Solution2 {
    static HashMap<String,Integer> map;
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

            int max = 0;

            for (int j = 0; j < orders.length; j++) {
                if (course[i] <= orders[j].length()) {
                    combi(orders[i], sb,  0, course[i],0);

                }
            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());
            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(max >=2 && entry.getValue() == max)
                    answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);
        return answer;
    }

    private static void combi(String order, StringBuilder sb, int idx, int course, int count) {
        if(course == count){
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
            return;
        }

        for(int i=idx; i<order.length(); i++){
            sb.append(order.charAt(i));
            combi(order,sb,idx+1, course, count+1);
            sb.delete(count,count+1);
        }

    }
}
