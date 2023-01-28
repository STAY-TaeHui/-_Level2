package com.company.숫자의표현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/12924
public class Main
{
    public static void main(String[] args)
    {
        Solution.solution(15);
    }

}
/*
1 + 2 + 3 + 4 + 5 = 15
4 + 5 + 6 = 15
7 + 8 = 15
15 = 15
1,3,5,15
1,4,16

8+9 = 17
1,17
* */
class Solution {
    public static int solution(int n) {
        int answer = 1;
        int sum=0;

        for(int i=1; i<=n/2; i++){
            for(int j=i; sum<n; j++){
                sum+=j;
                if(sum==n){
                    answer++;
                    break;
                }
            }
            sum=0;
        }
        System.out.println(answer);
        return answer;
    }
}