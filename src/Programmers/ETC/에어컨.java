package Programmers.ETC;

import java.util.Arrays;

public class 에어컨 {
    private static final int ON = 1;
    private static final int OFF = 0;
    private static final int STANDARD = 10;
    private static final int MAX_VALID = 100;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int[][] dp = new int[onboard.length][MAX_VALID+STANDARD];
        for(int i = 0 ; i < onboard.length ; i++){
            Arrays.fill(dp[i], NOT_VALID);
        }
        int answer = cal(0,temperature,temperature,t1,t2,a,b,onboard,dp);
        return answer;
    }
    private static final int INF = 987654321;
    private static final int NOT_VALID = -1;
    private static int cal(int depth,int outTemp,int inTemp, int t1, int t2, int a, int b,int[] onboard,
        int[][] dp){
        if(depth == onboard.length){
            return 0;
        }
        if(inTemp + STANDARD < 0 || inTemp + STANDARD >= MAX_VALID){
            return INF;
        }
        if(onboard[depth] == ON && (inTemp < t1 || inTemp > t2) ){
            return INF;
        }
        if(dp[depth][inTemp + STANDARD] != NOT_VALID){
            return dp[depth][inTemp + STANDARD];
        }
        int result = INF;
        if(outTemp < inTemp){
            result = Math.min(result, cal(depth+1,outTemp,inTemp+1,t1,t2,a,b,onboard,dp) + a);
            result = Math.min(result, cal(depth+1,outTemp,inTemp-1,t1,t2,a,b,onboard,dp));
        }
        if(outTemp > inTemp){
            result = Math.min(result, cal(depth+1,outTemp,inTemp-1,t1,t2,a,b,onboard,dp) + a);
            result = Math.min(result, cal(depth+1,outTemp,inTemp+1,t1,t2,a,b,onboard,dp));
        }
        if(outTemp == inTemp){
            result = Math.min(result, cal(depth+1,outTemp,inTemp+1,t1,t2,a,b,onboard,dp) + a);
            result = Math.min(result, cal(depth+1,outTemp,inTemp-1,t1,t2,a,b,onboard,dp) + a);
            result = Math.min(result, cal(depth+1,outTemp,inTemp,t1,t2,a,b,onboard,dp));
        }else{
            result = Math.min(result, cal(depth+1,outTemp,inTemp,t1,t2,a,b,onboard,dp) + b);
        }
        dp[depth][inTemp + STANDARD] = result;
        return result;
    }
}
