package com.company.다음큰숫자;

/*
* 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.
* */
public class Solution
{
    /*
    * 1001110(78) -> 1010000
    * 1001111 79
    * 1010000
    * 1010001
    * 1010010
    * 1010011
    * 1010011(83)
    * 1010101
    * */

    public int solution(int n) {

        int originCountOne = countOne(Integer.toBinaryString(n));

        while(true)
        {
            n++;
            int countOne = countOne(Integer.toBinaryString(n));
            if(originCountOne == countOne)
            {
              return n;
            }
        }
    }

    private int countOne(String binaryString)
    {
        return (int) binaryString.chars().filter(c->c=='1').count();
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.solution(78));
    }
}
