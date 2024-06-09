package com.company.스킬체크.Level1;

import java.util.Stack;

public class Level1 {
    public static void main(String[] args) {
        Solution.solution("1S2D*3T");
    }
}
class Solution{
    public static int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        char[] chars = dartResult.toCharArray();
        int point = 0;
        for(char c : chars){
            int cToInt = Character.getNumericValue(c);
            if (0 <= cToInt &&cToInt <= 10) {
                point = cToInt;
                continue;
            }
            else{
                switch (c){
                    case 'S':{//single
                        int pow = (int) Math.pow(point, 1);
                        st.add(pow);
                        continue;

                    }
                    case 'D':{//double
                        int pow = (int) Math.pow(point,2);
                        st.add(pow);
                        continue;
                    }
                    case 'T':{//triple
                        int pow = (int) Math.pow(point,3);
                        st.add(pow);
                        continue;
                    }
                    case '*':{
                        int temp = st.pop()*2;
                        if(!st.isEmpty())
                            temp +=st.pop()*2;
                        st.add(temp);
                    }
                    case '#':{
                        int temp = st.pop()*(-1);
                        if(!st.isEmpty())
                        temp += st.pop()*(-1);
                        st.add(temp);
                    }
                }
            }
        }
        for(int a : st){
            System.out.println(a);
            answer+=a;
        }
        System.out.println(answer);
        return answer;
    }
}