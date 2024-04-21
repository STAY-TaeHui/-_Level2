package com.company.스킬체크;

import java.util.ArrayList;
import java.util.List;

public class Level2_2 {
    public int solution(String s) {
        //abcabcbebe
        int pressLevel = 2;
        int answer = s.length();
        List<String> answerList = new ArrayList<>();

        int x = 0;
        while (pressLevel <= s.length() / 2) {
            int y = x + pressLevel;
            while(y<=s.length()) {
                String substring = s.substring(x, y);
                int count = 1;

                int nextX = y;
                int nextY = nextX + pressLevel;
                while (nextY <= s.length()) {
                    String next = s.substring(nextX, nextY);

                    if (substring.equals(next)) {
                        count++;
                        nextX += pressLevel;
                        nextY = nextX + pressLevel;
                    } else
                        break;
                }
                if (count > 1) {
                    s = s.replace(s.substring(x, nextX), s.substring(x, y));
                }
                x += pressLevel;
            }
            pressLevel++;
        }


        return answer;
    }
}
