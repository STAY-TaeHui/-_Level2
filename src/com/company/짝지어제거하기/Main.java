package com.company.짝지어제거하기;
//https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution.solution("acbbca");
    }
}

class Solution{
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> st = new Stack<>();
    public static int solution(String s){

        int id = 0;
        sb.append(s);
//        F_rc(sb,id);

        F_st(s);

        System.out.println(sb.toString());
        System.out.println(st.isEmpty() ? 1 : 0);
        return sb.length() > 0 ? 0 : 1;

    }
    //ababababababababababab
    private static void F_rc(StringBuilder sb, int id) {
        if(sb.length()>=0 && sb.length()-1>id){
            if (sb.charAt(id) == sb.charAt(id + 1)) {
               sb.delete(id,id+2);
               F_rc(sb, Math.max(id - 1, 0));
            }
            else{
                F_rc(sb,id+1);
            }
        }
    }
    private static void F_st(String s){
        for(char c : s.toCharArray()){
            if(!st.isEmpty()){
                if (st.peek().equals(c)) {
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
            else
                st.push(c);
        }

    }
}