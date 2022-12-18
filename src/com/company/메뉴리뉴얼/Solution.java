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
//https://fbtmdwhd33.tistory.com/249 참고
import java.util.*;

public class Solution
{
        // 12. combi 메소드에서 map에 접근하기 위해 전역변수로 선언.
        static HashMap<String,Integer> map;
        // 13. 조합을 구하는 메소드 (한 사람의 메뉴구성, 조합을 구할 StringBuilder, 조합을 위한 idx, 코스요리 개수에 따른 종료조건을 위한 cnt와 n)
        public static void combi(String str,StringBuilder sb,int idx, int cnt, int n){
            // 14. 각 코스요리의 개수만큼 조합이 되면,
            if(cnt == n) {
                // 15. map에 해당 조합을 삽입 및 카운팅.
                map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
                return;
            }

            // 16. idx부터 시작함으로써 조합을 구할 수 있다.
            for(int i = idx ; i<str.length();i++){
                // 17. sb에 붙여나간다.
                sb.append(str.charAt(i));
                // 18. 재귀호출.
                combi(str,sb,i+1,cnt+1,n);
                // 19. 붙였던거 다시 떼기.
                sb.delete(cnt,cnt+1);
            }
        }

        public ArrayList<String> solution(String[] orders, int[] course) {
            ArrayList<String> answer = new ArrayList<>();

            // 1. 각 문자열을 오름차순 정렬.
            for(int i =0;i<orders.length;i++){
                // 2. 각 문자열을 문자형 배열로 변환.
                char[] charArr = orders[i].toCharArray();
                // 3. 해당 문자형 배열을 정렬.
                Arrays.sort(charArr);
                // 4. 정렬된 문자형 배열을 문자열로 변환해 저장.
                orders[i] = String.valueOf(charArr);
            }

            // 5. course의 길이만큼 반복하여 필요한 조합을 구함.
            for(int i =0;i<course.length;i++){
                // 6. HashMap으로 조합의 수를 카운팅.
                map = new HashMap<>();
                // 7. course의 경우에 따라 구한 조합들 중 가장 많이 주문된 횟수를 저장.
                int max = Integer.MIN_VALUE;
                // 8. 각 사람들의 조합을 구하기 위해 탐색.
                for(int j =0;j<orders.length;j++){
                    // 9. 조합을 구하기 위해 문자열을 조작할 StringBuilder.
                    StringBuilder sb = new StringBuilder();
                    // 10. 코스의 개수 <= 각 문자열의 길이인 경우 조합을 구한다.
                    if(course[i]<=orders[j].length())
                        // 11. 조합을 구하기 위한 메소드 호출
                        combi(orders[j],sb,0,0,course[i]);
                }

                // 20. 가장 많이 주문된 횟수를 max에 저장.
                for(Map.Entry<String,Integer> entry : map.entrySet()){
                    max = Math.max(max,entry.getValue());

                }
                // 21. 최소 2번 이상 주문된 조합이며, 해당 횟수와 일치하는 조합은 ArrayList에 삽입.
                for(Map.Entry<String,Integer> entry : map.entrySet()){
                    if(max >=2 && entry.getValue() == max)
                        answer.add(entry.getKey());
                }
            }
            // 22. 추가된 조합들을 오름차순 정렬.
            Collections.sort(answer);

            return answer;
        }
}
