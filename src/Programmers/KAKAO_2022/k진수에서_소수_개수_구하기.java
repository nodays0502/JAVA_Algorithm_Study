package Programmers.KAKAO_2022;

import java.util.*;
class Solution {
    private static String numberToK(int n , int k){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n%k);
            n /= k;
        }
        sb = sb.reverse();
        return sb.toString();
    }
    private static int countPrime(String number){
        int result = 0;
        String[] temps = number.split("0");
        for(String temp : temps){
            // System.out.println(temp);
            if(!"".equals(temp) && !" ".equals(temp) && isPrime(temp)){
                result++;
            }
        }
        return result;
    }
    private static boolean isPrime(String number){
        long num = Long.parseLong(number);
        if(num == 1){
            return false;
        }
        for(long i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public int solution(int n, int k) {
        int answer = -1;
        String number = numberToK(n,k);
        answer = countPrime(number);
        return answer;
    }
}