package com.company.예상대진표;
//https://school.programmers.co.kr/learn/courses/30/lessons/12985
public class Main {
    public static void main(String[] args) {
        Solution.solution(8,4,7);
    }
}
class Solution
{
    public static int solution(int n, int a, int b)
    {
        int answer = 0;

        while (true)
        {
            //대진이 끝날 때 마다 수를 줄여 나간다.
            //1,2 -> 1
            //3,4 -> 2
            //5,6 -> 3
            //7,8 -> 4
            a = a/2 + a%2;
            b= b/2 + b%2;
            answer++;
            if (a == b)
            {
                break;
            }
        }
        return answer;
    }
}