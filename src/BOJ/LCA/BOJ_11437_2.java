package BOJ.LCA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11437_2 {
    static int[] parent;
    static int[] depth;
    static List<Integer>[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        map = new ArrayList[n+1];
        parent = new int[n+1];
        depth = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        Arrays.fill(parent,-1);
        parent[1] = 0;
        findParent(1,n);
//        System.out.println(Arrays.toString(parent));
        int m = stoi.apply(br.readLine());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            System.out.println(lca(a,b));
        }
    }

    private static void findParent(int now,int n) {
        for(int i = 0 ; i < map[now].size() ; i++){
            int next = map[now].get(i);
            if(parent[next] == -1){
                depth[next] = depth[now] + 1;
                parent[next] = now;
                findParent(next,n);
            }
        }
    }
//    private static int lca(int[] parent,int[] depth,int a, int b) {
//        while(true){
//            if(a == b){
//                return a;
//            }else if(depth[a] < depth[b]){
//                b = parent[b];
//            }else if(depth[a] > depth[b]){
//                a = parent[a];
//            }else {
//                if(parent[a] == parent[b]){
//                    return parent[a];
//                }else{
//                    a = parent[a];
//                    b = parent[b];
//                }
//            }
//        }
//    }
    private static int lca(int a, int b) {
        if(a == b){
            return a;
        }else if(depth[a] < depth[b]){
            return lca(a,parent[b]);
        }else if(depth[a] > depth[b]){
            return lca(parent[a],b);
        }else {
            if(parent[a] == parent[b]){
                return parent[a];
            }else{
                return lca(parent[a],parent[b]);
            }
        }
    }
}
