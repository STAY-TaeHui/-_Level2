package com.company.스킬체크.Level2_2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1Test {
    @Test
    public void listGetTest() {
        List<Integer> list = new ArrayList<>();

        list.add(9, 999);

        System.out.println(list.get(9));
        System.out.println(list.size());
    }
}
