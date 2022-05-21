package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17490 {
    private static class Edge{
        int start;
        int end;
        long weight;

        public Edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    private static int findSet(int now , int[] parent){
        if(now == parent[now]){
            return now;
        }
        return parent[now] = findSet(parent[now],parent);
    }
    private static boolean unionSet(int a, int b,int[] parent){
        int aParent = findSet(a,parent);
        int bParent = findSet(b,parent);
        if(aParent == bParent){
            return false;
        }
        parent[aParent] = bParent;
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        Function<String,Long> stol = Long::parseLong;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        long k = stol.apply(st.nextToken());
        int[] parent = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            parent[i] = i-1;
        }
        parent[1] = n;
        st = new StringTokenizer(br.readLine()," ");
        List<Edge> edges = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            long weight = stol.apply(st.nextToken());
            edges.add(new Edge(0,i,weight));
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int min = Math.min(a,b);
            int max = Math.max(a,b);
            if(min == 1 && max == n){
                parent[1] = 1;
                continue;
            }
            parent[max] = max;
        }
        if(m <= 1){
            System.out.println("YES");
            return ;
        }
        Collections.sort(edges,(o1,o2)->{
            if(o1.weight > o2.weight){
                return 1;
            }
            if(o1.weight < o2.weight){
                return -1;
            }
            return 0;
        });
        long result = 0;
        for(Edge edge : edges){
            if(unionSet(edge.start,edge.end,parent)){
                result += edge.weight;
            }
        }
//        System.out.println(Arrays.toString(parent));
//        System.out.println(result);
        if(result > k){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
    }
}
