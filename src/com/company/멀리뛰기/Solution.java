package com.company.멀리뛰기;

import com.company.스킬체크.Level2_2.Solution1;

import java.util.ArrayList;
import java.util.List;

/*
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12914
문제 설명 :
효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
(1칸, 1칸, 1칸, 1칸)
(1칸, 2칸, 1칸)
(1칸, 1칸, 2칸)
(2칸, 1칸, 1칸)
(2칸, 2칸)
의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다.
멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요.
 예를 들어 4가 입력된다면, 5를 return하면 됩니다.
* */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6);
    }
    private final long divNum = 1234567;
    public long solution(int n) {
        /*동적 프로그래밍 문제
        * dp(n) = dp(n-1)+dp(n-2)
        * */
        long[] answerArray = new long[n + 1];

        //초기화
        answerArray[0] = 1;
        answerArray[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            answerArray[i] = (answerArray[i - 1] + answerArray[i - 2])%divNum;
            System.out.println(answerArray[i]);
        }
        return answerArray[n];
    }
}