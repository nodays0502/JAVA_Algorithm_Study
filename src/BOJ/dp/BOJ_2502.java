package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2502 {
    private static final int A_TYPE = 0;
    private static final int B_TYPE = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        int[][] dp = new int[day+1][2];
        for(int i = 0 ; i <= day ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        dp[1][A_TYPE] = 1;
        dp[1][B_TYPE] = 0;
        dp[2][A_TYPE] = 0;
        dp[2][B_TYPE] = 1;
        int a = cal(day,A_TYPE,dp);
        int b = cal(day,B_TYPE,dp);
        for(int i = 1 ; i <= 100_000 ; i++){
            for(int j = 1 ; j <= 100_000 ; j++){
                if(num == a*i + b*j){
                    System.out.println(i);
                    System.out.println(j);
                    return ;
                }
            }
        }
    }
    private static final int NOT_VALID = -1;
    private static int cal(int day, int type,int[][] dp) {
        if(dp[day][type] != NOT_VALID){
            return dp[day][type];
        }
        return dp[day][type] = cal(day-1,type,dp) + cal(day-2,type,dp);
    }
}
