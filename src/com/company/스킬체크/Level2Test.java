package com.company.스킬체크;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Level2Test {

    @Test
    void solution() {
        Level2 level2 = new Level2();
        int n = 78;
        int solution = level2.solution(n);
        System.out.println(solution);
    }

    @Test
    void solution2() {
        Level2_2 level2_2 = new Level2_2();
        String s = "abcabcdede";//abc
        int solution = level2_2.solution(s);
        System.out.println(solution);


    }

}