package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13905_2 {
    private static class Edge{
        public int from;
        public int to;
        public int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private static final int INF  = 1_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int start = stoi.apply(st.nextToken());
        int end = stoi.apply(st.nextToken());
        List<Edge> list = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            list.add(new Edge(a,b,c));
        }

        System.out.println(kruskal(list,start,end,n,m));
    }
    private static int findSet(int now, int[] parent){
        if(parent[now] == now){
            return now;
        }
        return parent[now] = findSet(parent[now],parent);
    }
    private static boolean union(int a , int b,int[] parent){
        int aParent = findSet(a,parent);
        int bParent = findSet(b,parent);
        if(aParent == bParent){
            return false;
        }
        parent[aParent] = bParent;
        return true;
    }
    private static int kruskal(List<Edge> list,int start, int end ,int n,int m) {
        int[] parent = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }
        Collections.sort(list,(o1,o2)->{
            return o2.weight - o1.weight;
        });
        for(Edge edge : list){
            if(union(edge.from,edge.to,parent)){
                if(findSet(start,parent) == findSet(end,parent)){
                    return edge.weight;
                }
            }
        }
        return 0;
    }
}
