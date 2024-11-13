package com.company.퍼즐게임챌린지;
//https://school.programmers.co.kr/learn/courses/30/lessons/340212?language=java

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        [1, 4, 4, 2]	[6, 3, 8, 2]	59	2
//        [1, 328, 467, 209, 54]	[2, 7, 1, 4, 3]	1723	294
//        Solution.solution(new int[]{1,4,4,2}, new int[]{6,3,8,2}, 59);
        Solution.solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723);
    }
}

class Solution {
    public static int solution(int[] diffs, int[] times, long limit) {
        //diff : 난이도
        //time_cur : 현재 소요 시간
        //time_prev : 이전 소요 시간
        //level : 숙련도

        //제한시간 limit내에 퍼즐을 모두 해결하기 위한 level의 최솟값
        int forCount = 0;
        long minLevel = 0;
        int halfLevel = Arrays.stream(diffs)
                .max()
                .getAsInt();

        do {
            halfLevel = halfLevel/2;
            int totalTime = 0;

            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] > halfLevel) {
                    totalTime = totalTime + calculateSpendTime(diffs[i], times[i], times[i-1], halfLevel);
                } else {
                    totalTime = totalTime + times[i];
                }

                if (limit < totalTime) {//글러먹었다. limit를 넘김
                    //level 다시 반으로 줄이고 처음부터 다시 계산
                    if (halfLevel == 1) {
                        return (int) minLevel;
                    }
                    i=0;
                    totalTime = 0;
                    halfLevel = halfLevel+halfLevel/2;
                }
            }
            minLevel = halfLevel;
            forCount++;
        }while(halfLevel!=1);//계속 반갈죽해서 1이 될때까지 반복

        System.out.println(minLevel+"!!!!!!!");
        return (int) minLevel;
    }

    private static int calculateSpendTime(int diff, int time_cur, int time_prev, int level) {
        return (diff - level) * (time_cur + time_prev) + time_cur;
    }
}