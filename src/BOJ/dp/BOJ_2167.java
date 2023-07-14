package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2167 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] input = new int[n+1][m+1];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= m ; j++){
                input[i][j] = stoi.apply(st.nextToken());
            }
        }
        int[][] dp = new int[n+1][m+1];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                dp[i][j] = input[i][j];
                dp[i][j] += dp[i-1][j];
                dp[i][j] += dp[i][j-1];
                dp[i][j] -= dp[i-1][j-1];
            }
        }
        int testCnt = stoi.apply(br.readLine());
        for(int t = 0 ; t < testCnt ; t++){
            st = new StringTokenizer(br.readLine());
            int startY = stoi.apply(st.nextToken());
            int startX = stoi.apply(st.nextToken());
            int endY = stoi.apply(st.nextToken());
            int endX = stoi.apply(st.nextToken());
            System.out.println(dp[endY][endX] - dp[endY][startX-1] - dp[startY-1][endX] + dp[startY-1][startX-1]);
        }
    }

}
