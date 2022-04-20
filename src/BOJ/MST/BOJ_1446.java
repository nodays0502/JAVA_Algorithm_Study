package BOJ.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1446 {

    private static class Edge {

        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        int result = 0;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        Edge[] edges = new Edge[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = stoi.apply(st.nextToken());
            int end = stoi.apply(st.nextToken());
            int weight = stoi.apply(st.nextToken());
            edges[i] = new Edge(start, end, weight);
        }
        Arrays.sort(edges, (o1, o2) -> {
            return o1.start - o2.start;
        });
        int[][] dp = new int[n][10_000+1];
        result = dfs(0, 0,edges, n, m,dp);
        System.out.println(result);
    }

    private static int dfs(int depth, int start, Edge[] edges, int n, int m,int[][] dp) {
        if (depth == n) {
            return m;
        }
        if(dp[depth][start] != 0){
            return dp[depth][start];
        }
        int result = m;
        if (start <= edges[depth].start && edges[depth].end <= m) {
            int distance = dfs(depth + 1, edges[depth].end, edges, n, m,dp)
                - (edges[depth].end - edges[depth].start) + edges[depth].weight;
            result = Math.min(result,distance);
        }
        result = Math.min(result,dfs(depth+1,start,edges,n,m,dp));
        dp[depth][start] = result;
        return result;
    }
}
