package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_6497 {
    private static class Edge{
        int start;
        int end;
        int weight;
        public Edge(int start,int end, int weight){
            this.start = start;
            this.end = end;
            this.weight  = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0){
                break;
            }
            List<Edge> edges = new ArrayList<>();
            int totalMoney = 0;
            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edges.add(new Edge(x,y,weight));
                totalMoney += weight;
            }
            int saveMoney = cal(edges,n);
            System.out.println(totalMoney - saveMoney);
        }
    }
    private static int findSet(int now, int[] parent){
        if(parent[now] == now){
            return now;
        }
        return parent[now] = findSet(parent[now], parent);
    }
    private static boolean union(int a,int b,int[] parent){
        int aParent = findSet(a,parent);
        int bParent = findSet(b,parent);
        if(aParent == bParent){
            return false;
        }
        parent[aParent] = bParent;
        return true;
    }
    private static int cal(List<Edge> edges, int n){
        edges.sort((v1,v2)->{
            return v1.weight - v2.weight;
        });
        int[] parent = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }
        int weightSum = 0;
        for(Edge edge : edges){
            if(union(edge.start, edge.end, parent)) {
                weightSum += edge.weight;
            }
        }
        return weightSum;
    }

}