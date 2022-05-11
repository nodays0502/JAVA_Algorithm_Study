package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16202 {
    private static class Edge{
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
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        List<Edge> list = new ArrayList<>();
        int[] used = new int[n+1];
        for(int i = 1 ; i <= m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            list.add(new Edge(a,b,i));
        }
        for(int i = 0 ; i < k ; i++){
            System.out.print(kruskal(list,i,n)+" ");
        }
    }
    private static final int INF = 987654321;
    private static int kruskal(List<Edge> list,int start,int n){
        int[] parent = new int[n+1];
        for(int i = 1; i <= n ; i++){
            parent[i] = i;
        }
        int result = 0;
        int cnt = 1;
        for(int i = start ; i < list.size() ; i++){
            Edge edge = list.get(i);
            if(union(edge.start,edge.end,parent)){
                cnt++;
                result += edge.weight;
                if(cnt == n){
                    return result;
                }
            }
        }
        return 0;
    }
    private static int findSet(int now, int[] parent){
        if(now == parent[now]){
            return now;
        }
        return parent[now] = findSet(parent[now],parent);
    }
    private static boolean union(int a, int b, int[] parent){
        int aParent = findSet(a,parent);
        int bParent = findSet(b,parent);
        if(aParent == bParent){
            return false;
        }
        parent[aParent] = bParent;
        return true;
    }
}
