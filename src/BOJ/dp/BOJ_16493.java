package BOJ.dp;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16493 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] input = new int[m][2];
        int[][] dp = new int[m][n+1];
        for(int i = 0 ; i < m ; i++){
            Arrays.fill(dp[i],NOT_VALID);
            st = new StringTokenizer(br.readLine());
            int day = stoi.apply(st.nextToken());
            int page = stoi.apply(st.nextToken());
            input[i][0] = day;
            input[i][1] = page;
        }
        int result = cal(0,input,n,m,dp);
        System.out.println(result);
    }
    private static final int NOT_VALID = -1;
    private static int cal(int depth, int[][] input, int day, int m,int[][] dp) {
        if(depth >= m){
            return 0;
        }
        if(dp[depth][day] != NOT_VALID){
            return dp[depth][day];
        }
        int result = 0;
        if(input[depth][0] <= day){
            result = Math.max(result,cal(depth+1,input,day-input[depth][0],m,dp) + input[depth][1]);
        }
        result = Math.max(result,cal(depth+1,input,day,m,dp));
        dp[depth][day] = result;
        return result;
    }
}
