package com.company.올바른괄호;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution.solution("(())()");
    }
}
class Solution{
    static Stack<Character> st;
    static boolean  solution(String s) {
        boolean answer = true;
        char[] brackets = s.toCharArray();
        if( brackets[0] == ')'){
            return false;
        }

        st = new Stack<>();
        for(char bracket : brackets){
            if (bracket == '(') {
                st.push(bracket);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else
                    st.pop();
            }
        }
        if (!st.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}
