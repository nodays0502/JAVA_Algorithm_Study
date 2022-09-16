package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2624 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int money = stoi.apply(br.readLine());
        int n = stoi.apply(br.readLine());
        int[][] input = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = stoi.apply(st.nextToken());
            input[i][1] = stoi.apply(st.nextToken());
        }
        int[][] dp = new int[money+1][n];
        for(int i = 0 ; i <= money ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        int result = cal(money,n-1,input,dp);
        System.out.println(result);
    }
    private static final int NOT_VALID = -1;
    private static int cal(int money, int index,int[][]input, int[][] dp){
        if(money == 0){
            return 1;
        }
        if(index < 0){
            return 0;
        }
        if(dp[money][index] != NOT_VALID){
            return dp[money][index];
        }

        int result = 0;
        for(int i = 0 ; i <= input[index][1] ; i++){
            int remainder = money - input[index][0] * i;
            if(remainder >= 0){
                result += cal(remainder,index-1,input,dp);
            }
        }
        return dp[money][index] = result;
    }
}
