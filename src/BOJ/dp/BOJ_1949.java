package BOJ.dp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1949 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] amount = new int[n+1];
        List<Integer>[] map = new ArrayList[n+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= n ; i++){
            map[i] = new ArrayList<>();
            amount[i] = stoi.apply(st.nextToken());
        }
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        int [][] dp = new int[n+1][2]; // 1 = 우수 마을
        boolean[] visited = new boolean[n+1];
        dfs(map,dp,1,visited,n,amount);
        int result = Math.max(dp[1][0],dp[1][1]);
        System.out.println(result);
    }

    private static void dfs(List<Integer>[] map, int[][] dp, int now,boolean[]visited, int n,int[] amount) {
//        System.out.println(now);
        visited[now] = true;
        dp[now][1] = amount[now];
        dp[now][0] = 0;
        for(int i = 0 ; i < map[now].size() ; i++){
            int next = map[now].get(i);
            if(visited[next]){
                continue;
            }
            dfs(map,dp,next,visited,n,amount);
            dp[now][0] += Math.max(dp[next][1],dp[next][0]);
            dp[now][1] += dp[next][0];
        }
    }
}
