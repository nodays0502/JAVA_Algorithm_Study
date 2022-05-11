package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2533 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        List<Integer>[] map = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        int[][] dp = new int[n+1][2];
        boolean[] visited = new boolean[n+1];
        int result = dfs(map,1,dp,visited);
        System.out.println(result);
    }

    private static int dfs(List<Integer>[] map, int now, int[][] dp, boolean[] visited) {
        visited[now] = true;
        dp[now][1] = 1;
        dp[now][0] = 0;
        for(int i = 0 ; i < map[now].size(); i++){
            int next = map[now].get(i);
            if(visited[next]){
                continue;
            }
            dfs(map,next,dp,visited);
            dp[now][0] += dp[next][1];
            dp[now][1] += Math.min(dp[next][0],dp[next][1]);
        }
        return Math.min(dp[now][0],dp[now][1]);
    }
}
