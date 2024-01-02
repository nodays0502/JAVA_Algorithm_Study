package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21317_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] energy = new int[n][2];
        int[][] dp = new int[n][2];
        for(int i = 0 ; i < n-1 ; i++){
            Arrays.fill(dp[i],NOT_VALID);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 2; j++){
                energy[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = Integer.parseInt(br.readLine());
        int result = cal(0,NOT_USED,energy,k,n-1,dp);
        System.out.println(result);
    }
    private static final int NOT_USED = 0;
    private static final int NOT_VALID = -1;
    private static final int USED = 1;
    private static final int INF = 987654321; // 5000 * 20
    private static int cal(int depth, int used, int[][] energy, int k, int n,int[][] dp) {
        if(depth == n){
            return 0;
        }
        if(dp[depth][used] != NOT_VALID){
            return dp[depth][used];
        }
        int result = INF;
        for(int i = 0 ; i < 2; i++){
            if(depth+i+1 <= n){
                result = Math.min(result,cal(depth+i+1,used,energy,k,n,dp) + energy[depth][i]);
            }
        }
        if(depth+3 <= n && used == NOT_USED){
            result = Math.min(result,cal(depth+3,USED,energy,k,n,dp) + k);
        }
        dp[depth][used] = result;
        return result;
    }
}
