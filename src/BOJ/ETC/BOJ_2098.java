package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2098 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int[][] dp = new int[16][ONE << 16];
        int result = dfs(0,0,1,map,n,dp);
        System.out.println(result);
    }

    private static final int INF = 987654321;
    private static final int ONE = 1;

    private static int dfs(int depth, int now, int route, int[][] map, int n,int[][] dp) {
        if(depth == n-1 && map[now][0] != 0){
            return map[now][0];
        }
        if(depth == n-1){
            return INF;
        }
        if(dp[now][route] != 0){
            return dp[now][route];
        }
        int result = INF;
        for(int i = 0 ; i < n ; i++){
            if((route & (ONE << i) ) > 0 || map[now][i] == 0){
                continue;
            }
            int nextRoute = route | (ONE << i);
            result = Math.min(result,map[now][i] + dfs(depth +1,i,nextRoute,map,n,dp));
        }
        dp[now][route] = result;
        return result;
    }
}
