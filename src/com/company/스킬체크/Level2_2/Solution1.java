package com.company.스킬체크.Level2_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
//https://school.programmers.co.kr/learn/courses/30/lessons/72411
/*["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]*/
public class Solution1 {
    private Map<String, Integer> resultMap;
    private int maxCount;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        //ABCFG
        //AC
        //CDE
        //ACDE
        //BCFG
        //ACDEH

//        for (int courseNum : course) {
//            makeCourse(orders, courseNum);
//        }
        makeCourse(new String[]{"ABCD"}, 2);
        return answer;
    }

    private void makeCourse(String[] orders, int courseNum) {
        resultMap = new HashMap<>();
        maxCount = 0;
        for (String order : orders) {
            combineMenu(order, "", 0, courseNum);
        }
        checkCount(resultMap);
    }

    private void checkCount(Map<String, Integer> resultMap) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            if (maxCount < entry.getValue()) {
                maxCount = entry.getValue();
                sb.setLength(0);
                sb.append(entry.getKey());
            }
        }
    }

    private void combineMenu(String order, String currentCourse, int i, int courseNum) {
        if (currentCourse.length() == courseNum) {
            putResultMap(currentCourse);
            return;
        }
        if (order.length() <= i) {
            return;
        }

        combineMenu(order, currentCourse + order.charAt(i), i+1, courseNum);
        combineMenu(order, currentCourse, i+1, courseNum);
    }

    private void putResultMap(String currentCourse) {
        System.out.println(currentCourse);

        Optional<Integer> countOptional = Optional.ofNullable(resultMap.get(currentCourse));

        resultMap.put(currentCourse, countOptional.isEmpty() ? 1 : Integer.valueOf(countOptional.get() + 1));
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.solution(null, null);

    }
}
