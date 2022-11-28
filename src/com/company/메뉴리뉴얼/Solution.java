package com.company.메뉴리뉴얼;

/*
* https://school.programmers.co.kr/learn/courses/30/lessons/72411
* 레스토랑을 운영하던 스카피는 코로나19로 인한 불경기를 극복하고자 메뉴를 새로 구성하려고 고민하고 있습니다.
기존에는 단품으로만 제공하던 메뉴를 조합해서 코스요리 형태로 재구성해서 새로운 메뉴를 제공하기로 결정했습니다. 어떤 단품메뉴들을 조합해서 코스요리 메뉴로 구성하면 좋을 지 고민하던 "스카피"는 이전에 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다.
단, 코스요리 메뉴는 최소 2가지 이상의 단품메뉴로 구성하려고 합니다. 또한, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함하기로 했습니다.

예를 들어, 손님 6명이 주문한 단품메뉴들의 조합이 다음과 같다면,
(각 손님은 단품메뉴를 2개 이상 주문해야 하며, 각 단품메뉴는 A ~ Z의 알파벳 대문자로 표기합니다.)
*
* 각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, "스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때,
*  "스카피"가 새로 추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
* */

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution
{
    static StringTokenizer st;
    static Map<Character,Integer> map;
    public static void main(String[] args)
    {
        solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},new int[]{2,3,4});
    }
    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        map = new HashMap<>();
        for (String order : orders)
        {
            char[] chars = order.toCharArray();
            for (char menu : chars)
            {
                if (!map.containsKey(menu))
                {
                    map.put(menu,1);
                }
                else{
                    map.put(menu,map.get(menu)+1);
                }
            }
        }

        System.out.println(map);

        return answer;
    }
}
