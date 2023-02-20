package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1197_2 {
    private static final int BLOCK = 1_000_001;
    private static class Edge{
        int start;
        int end;
        int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int v = stoi.apply(st.nextToken());
        int e = stoi.apply(st.nextToken());
        List<Edge> edges = new LinkedList<>();
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            edges.add(new Edge(a,b,c));
        }
        edges.sort((v1,v2)->{
            return v1.value - v2.value;
        });
        int[] parent = new int[v+1];
        for(int i = 1 ; i  <= v; i++){
            parent[i] = i;
        }
        int result = 0;
        for(Edge edge : edges){
            if(union(edge.start,edge.end,parent)){
                result += edge.value;
            }
        }
        System.out.println(result);
    }
    private static int findParent(int num,int[] parent){
        if(num == parent[num]){
            return num;
        }
        return parent[num] = findParent(parent[num],parent);
    }
    private static boolean union(int a, int b, int[] parent){
        int aParent = findParent(a,parent);
        int bParent = findParent(b,parent);
        if(aParent == bParent){
            return false;
        }
        parent[aParent] = bParent;
        return true;
    }
}
