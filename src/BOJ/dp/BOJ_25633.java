package BOJ.dp;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_25633 {
    private static final int INF = 987654321;
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] input = new int[n][m];
        int[][][] dp = new int[n][m][3];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                Arrays.fill(dp[i][j],NOT_VALID);
                input[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = INF;
        for(int i = 0 ; i < m ; i++){
            result = Math.min(result,cal(0,i,input,n,m,dp,-1));
        }
        System.out.println(result);
    }
    private static final int[] DX = {-1,0,1};
    private static int cal(int y, int x, int[][] input, int n, int m,int[][][] dp,int dir) {
        if(y == n){
            return 0;
        }
        if(y != 0 && dp[y][x][dir] != NOT_VALID){
            return dp[y][x][dir];
        }
        int result = INF;
        for(int i = 0 ; i < 3 ; i++){
            if(dir == i){
                continue;
            }
            int nx = x + DX[i];
            if(nx >= 0 && nx < m){
                result = Math.min(result,cal(y+1,nx,input,n,m,dp,i));
            }
        }
        result += input[y][x];
        if(y != 0){
            dp[y][x][dir] = result;
        }
        return result;
    }
}
