package com.company.스킬체크.Level1;

import java.util.Arrays;
import java.util.Stack;

public class Level1_2 {
    public static void main(String[] args) {
//        Solution2.solution(118372);
        Solution3.solution("banana");
    }
}
class Solution2{// 숫자를 desc 정렬
    public static long solution(long n) {
        long answer = 0;
        String nStr = n+"";
        char[] chars = nStr.toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        sb.append(chars);
        sb.reverse();
        System.out.println(sb);
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
class Solution3{//banana --> 처음인 문자는 -1, 나왔던 문자는 이전 문자의 index
    public static int[] solution(String s) {
        int[] answer = {};
        answer= new int[s.length()];
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(!st.contains(c)) {
                st.add(c);
                answer[i] = -1;
            }
            else{
                int search = st.search(c);
                st.add(c);
                answer[i] = search;
            }

        }
        return answer;
    }
}
