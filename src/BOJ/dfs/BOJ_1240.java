package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1240 {
    private static class Edge{
        int next;
        int weight;

        public Edge(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Edge>[] edges = new List[n+1];
        for(int i = 1 ; i <= n ; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            edges[a].add(new Edge(b,c));
            edges[b].add(new Edge(a,c));
        }
        for(int i = 0 ; i < m ; i++){
            boolean[] visited = new boolean[n+1];
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
//            System.out.println(findDistanceDfs(a,b,edges,visited));
            System.out.println(findDistanceBfs(a,b,edges,visited));
        }
    }
    private static int findDistanceDfs(int now, int b, List<Edge>[] edges,boolean[] visited) {
        visited[now] = true;
        if(now == b){
            return 0;
        }
        int result = -1;
        for(Edge edge : edges[now]){
            if(!visited[edge.next]){
                result = findDistanceDfs(edge.next,b,edges , visited);
                if(result != -1){
                    result += edge.weight;
                    return result;
                }
            }
        }
        return -1;
    }
    private static int findDistanceBfs(int a, int b, List<Edge>[] edges,boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a,0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == b){
                return now[1];
            }
            for(Edge edge : edges[now[0]]){
                if(!visited[edge.next]){
                    visited[edge.next] = true;
                    q.offer(new int[] {edge.next,now[1] + edge.weight});
                }
            }
        }
        return -1;
    }
}
