package Programmers.ETC;

public class 피보나치_수 {
    private static final int LIMIT = 1234567;
    private static final int NOT_VALID = 0;
    public int solution(int n) {
        int[] dp = new int[n+1];
        int answer = fib(n,dp);
        return answer;
    }
    private int fib(int num,int[] dp){
        if(num == 0 || num == 1){
            return num;
        }
        if(dp[num] != NOT_VALID){
            return dp[num];
        }
        return dp[num] = (fib(num-1,dp) + fib(num-2,dp)) % LIMIT;
    }
}
