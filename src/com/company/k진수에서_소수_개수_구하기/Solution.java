package com.company.k진수에서_소수_개수_구하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*문제 설명 https://school.programmers.co.kr/learn/courses/30/lessons/92335
양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.

0P0처럼 소수 양쪽에 0이 있는 경우
P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
P처럼 소수 양쪽에 아무것도 없는 경우
단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
예를 들어, 101은 P가 될 수 없습니다.
예를 들어, 437674을 3진수로 바꾸면 211 0 2 0 1 0 1 0 11입니다.
11 0 0 11
여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다. (211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.) 211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.

정수 n과 k가 매개변수로 주어집니다. n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.
*/
public class Solution
{
    public int solution(int n, int k) {
        int answer = 0;

        StringBuilder temp = new StringBuilder();
        //StringBuilder 가 String 을 사용하는 것 보다 빠름.
        while(n !=0){
            temp.insert(0,n % k);
            n=n/k;
        }

        String[] splitTemp = temp.toString().split("0");

        for(String s : splitTemp){
            //s가 비어있거나 1인경우 생략
            if(s.equals("") || s.equals("1")){
                continue;
            }
            answer = getPrimeCount(s) ? (answer + 1) : answer;
        }
        return answer;
    }
    private boolean getPrimeCount(String primeNum)
    {
            long isPrime= Long.parseLong(primeNum);

            //값이 2인경우 소수이기 때문에 바로 true 반환.
            if(isPrime==2) return true;

            //에라토스테네스의 체 -> 소수는 k의 제곱근 까지만 체크하면 됨.
            for(int i=2; i<Math.sqrt(isPrime)+1; i++){
                if (isPrime % i == 0)
                {
                   return false;
                }
            }
        return true;
    }
}
