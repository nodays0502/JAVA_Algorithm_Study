package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_23743 {
    static class Edge{
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Edge> edges = new LinkedList<>();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int start = stoi.apply(st.nextToken());
            int end = stoi.apply(st.nextToken());
            int weight = stoi.apply(st.nextToken());
            edges.add(new Edge(start,end,weight));
        }
        int[] parent = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            int weight = stoi.apply(st.nextToken());
            edges.add(new Edge(0,i,weight));
        }
        edges.sort((o1,o2)->{
            return o1.weight - o2.weight;
        });
        int result = 0;
        for(Edge edge : edges){
            if(unionSet(edge.end, edge.start,parent)){
//                System.out.println(edge.start+" "+edge.end+" "+edge.weight);
                result += edge.weight;
            }
        }
        System.out.println(result);
    }
    private static int findSet(int now, int[] parent){
        if(now == parent[now]){
            return now;
        }
        return parent[now] = findSet(parent[now],parent);
    }
    private static boolean unionSet(int a,int b,int[] parent){
        int aParent = findSet(a,parent);
        int bParent = findSet(b,parent);
        if(aParent == bParent){
            return false;
        }
        parent[aParent] = bParent;
        return true;
    }

}
