package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_20010 {
    static class Edge{
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        List<Edge> edges = new LinkedList<>();

        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            edges.add(new Edge(a, b, c));
        }
        edges.sort((o1,o2)->{
            return o1.cost - o2.cost;
        });
        List<int[]>[] map = kruskal(edges,n);

        boolean[] visited = new boolean[n];
        int maxCost = 0;
        for(int i = 0 ; i < n ; i++){
            maxCost = Math.max(maxCost,bfs(i,map,n));
        }
        System.out.println(maxCost);
    }
    private static final int INF = 987654321;
    private static int findSet(int now, int[] parent){
        if(now == parent[now]){
            return now;
        }
        return parent[now] = findSet(parent[now],parent);
    }
    private static boolean unionSet(int a,int b, int[] parent){
        int aParent = findSet(a,parent);
        int bParent = findSet(b,parent);
        if(aParent == bParent){
            return false;
        }
        parent[aParent] = bParent;
        return true;
    }
    private static List<int[]>[] kruskal(List<Edge> edges, int n){
        int sum = 0;
        int[] parent = new int[n];
        for(int i = 0 ; i < n ; i++){
            parent[i] = i;
        }
        List<int[]>[] map = new List[n];
        for(int i = 0 ; i < n ; i++){
            map[i] = new LinkedList<>();
        }
        for(Edge edge : edges){
            if(unionSet(edge.start, edge.end,parent)){
                sum += edge.cost;
                map[edge.start].add(new int[] {edge.end,edge.cost});
                map[edge.end].add(new int[] {edge.start,edge.cost});
            }
        }
        System.out.println(sum);
        return map;
    }

    private static int bfs(int num,List<int[]>[] map, int n) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{num, 0});
        boolean[] visited = new boolean[n];
        visited[num] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            result = Math.max(result,now[1]);
            for(int[] next : map[now[0]]){
                if(!visited[next[0]]){
                    visited[next[0]] = true;
                    q.offer(new int[] {next[0],now[1] + next[1]});
                }
            }
        }
        return result;
    }
}
