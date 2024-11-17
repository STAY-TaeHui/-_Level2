package com.company.퍼즐게임챌린지;
//https://school.programmers.co.kr/learn/courses/30/lessons/340212?language=java

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        [1, 4, 4, 2]	[6, 3, 8, 2]	59	2
//        [1, 5, 3]	[2, 4, 7]	30	3
        /*
        * 5/2 = 2 => midLevel
        * 1 - 2;
        * 5 : 5-2 * 6 + 4 = 22;
        * 3 : 3-2 * 11 + 7 = 21;
        * 오른쪽으로 이동 -> 2-5 의 중간 : 7/2 = 3
        * 1: 2;
        * 5 : 5-3 * 6 +4 = 16;
        * 3 : 7;
        * 25;
        * 4일때는?
        * 1: 2;
        * 5 : 5-4 * 6 + 4 = 10;
        * 3 : 7;
        * 19;
        * */
        //[1, 1, 1, 5, 1]   [1, 1, 1, 1, 1]  100
        /*
        2부터
        1 : 1;
        2 : 1;
        3 : 1;
        4 : 5-1 * 1 + 1 = 5;
        5 : 1;
        * */
//        [1, 328, 467, 209, 54]	[2, 7, 1, 4, 3]	1723	294
//        	[1, 99999, 100000, 99995], [9999, 9001, 9999, 9001], 3456789012
//        Solution.solution(new int[]{1,4,4,2}, new int[]{6,3,8,2}, 59);
//        Solution.solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723);

        Solution.solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L);
    }
}

class Solution {
    public static int solution(int[] diffs, int[] times, long limit) {
        //diff : 난이도
        //time_cur : 현재 소요 시간
        //time_prev : 이전 소요 시간
        //level : 숙련도

        Btree btree = new Btree(
            Arrays.stream(diffs).max().getAsInt(),
            1
        );


        int result = 0;
        while(btree.min <= btree.max) {
            long totalTime = times[0];

            for (int i = 1; i < diffs.length; i++) {
                if (diffs[i] > btree.mid) {
                    totalTime += calculateSpendTime(diffs[i], times[i], times[i - 1], btree.mid);
                } else
                    totalTime += times[i];

                if (limit < totalTime) {
                    btree.moveLevelToRight();
                    break;// 이후는 숙련도가 모자르기 때문에 볼필요 없음.
                }
            }

            if(limit >= totalTime) {
                result = btree.mid;
                btree.moveLevelToLeft();
            }
        }
        System.out.println(result);
        return result;
    }

    private static class Btree {
        private int max;
        private int min;
        private int mid;

        public Btree(int max, int min) {
            this.max = max;
            this.min = min;
            this.mid = max/2;
        }

        public void moveLevelToRight() {
            this.min = mid + 1;
            this.mid = (min + max) / 2;
        }
        public void moveLevelToLeft() {
            this.max = mid - 1;
            this.mid = (min + max) / 2;
        }
    }

    private static int calculateSpendTime(int diff, int time_cur, int time_prev, int level) {
        return (diff - level) * (time_cur + time_prev) + time_cur;
    }
}