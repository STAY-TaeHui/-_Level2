package com.company.영어끝말잇기;

import java.util.Arrays;
import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/12981
public class Main {
    public static void main(String[] args) {
//        Solution.solution(5,new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
//        Solution.solution(2,new String[]{"hello", "one", "even", "never", "now", "world", "draw"});
        Solution.solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});

    }
}
/*
* 체크
* 1. 마지막 글자인지
* 2. new Array 있는지 확인해서 없으면 넣고
* 3. 별 이슈 없으면 0,0 리턴
 */
class Solution {
    static Stack<String> stack = new Stack<>();
    public static int[] solution(int n, String[] words) {
        int[] answer = {};

        for(String word : words){
            //첫번째
            if(stack.size()==0){
                stack.add(word);
                continue;
            }

            //마지막 글자가 맞는지
            if(lastEqFirst(word)){
                //stack 에서 word가 있는지 확인
                if(!stack.contains(word)){//동일단어 없을때
                    System.out.println("continue");
                    stack.add(word);
                    continue;
                }
                else{
                    return returnAnswer(n);
                }
            }
            //마지막 글자 안맞을때
            else{
                return returnAnswer(n);
            }

        }
        answer = new int[]{0, 0};
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    //끝말잇기가 가능한지 마지막 글자와 첫글자 체크
    private static boolean lastEqFirst(String word) {
        System.out.println("last = " + stack.peek());
        System.out.println("First = " + word);
        return stack.peek().charAt(stack.peek().length()-1) == word.charAt(0);
    }

    //Answer 리턴하기
    private static int[] returnAnswer(int n) {
        int userNum = 0;
        int count = 0;
        userNum = stack.size() % n + 1;
        count = stack.size() / n + 1;

        System.out.println("userNum : " + userNum);
        System.out.println("count : " + count);

        return new int[]{userNum,count};


    }
}

