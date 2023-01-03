package com.company.카펫;
//https://school.programmers.co.kr/learn/courses/30/lessons/42842
/*
0000  [12,4]
0**0
0**0
0000

000000  [14,4]
0****0
000000
*/

public class Main
{
    public static void main(String[] args)
    {
        Solution.solution(10,2);
    }
}
class Solution {
    static int height;
    static int width;
    public static int[] solution(int brown, int yellow) {
        int[] answer = {0,0};


        for(int yHeight = 1; yHeight<=(int) Math.sqrt(yellow); yHeight++){
            if (yellow % yHeight == 0)
            {
                int yWidth=yellow/yHeight;
                if((yHeight+2) * (yWidth+2) == brown+yellow){
                    height = yHeight+2;
                    width = yWidth+2;
                    break;
                }
            }
        }
        answer[0] = width;
        answer[1] = height;
        return answer;
    }
}