package com.company.이진변환반복;
//https://school.programmers.co.kr/learn/courses/30/lessons/70129
public class Main {
    public static void main(String[] args) {
        Solution.solution("01110");
    }
}
class Solution {
    static int delete_count=0;
    static int zero_count=0;
    public static int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();
        delete_zero(sb.append(s).toString());

        answer[0] = delete_count;
        answer[1] = zero_count;
        return answer;
    }
    public static void delete_zero(String binary){
        if("1".equals(binary)){
            return ;
        }
        else {
            delete_count++;
            int next_binary = binary.replaceAll("0", "").length();
            int zero_len = binary.length() - next_binary;
            zero_count+=zero_len;
            delete_zero(Integer.toBinaryString(next_binary));
        }
    }
}
