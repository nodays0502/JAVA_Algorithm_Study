package BOJ.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3584 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0 ; t < test ; t++){
            st = new StringTokenizer(br.readLine()," ");
            int n = stoi.apply(st.nextToken());

            List<Integer>[] map = new ArrayList[n+1];
            int[] parent = new int[n+1];
            for(int i = 1 ; i <= n ; i++){
                map[i] = new ArrayList<>();
                parent[i] = i;
            }
            for(int i = 0 ; i < n -1 ; i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = stoi.apply(st.nextToken());
                int b = stoi.apply(st.nextToken());
                parent[b] = a;
                map[a].add(b);
            }

            int[] degree = new int[n+1];
            checkDegree(map,parent,degree,n);
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            System.out.println(lca(parent,degree,a,b));
        }
    }

    private static int lca(int[] parent, int[] degree, int a, int b) {
        if(degree[a] == degree[b]){
            if(a == b){
                return a;
            }else if(parent[a] == parent[b]){
                return parent[a];
            }else{
                return lca(parent,degree,parent[a],parent[b]);
            }
        }
        if(degree[a] > degree[b]){
            return lca(parent,degree,parent[a],b);
        }else{
            return lca(parent,degree,a,parent[b]);
        }
    }

    private static void checkDegree(List<Integer>[] map,int[] parent, int[] degree, int n) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            if(parent[i] == i){
                q.offer(i);
                break;
            }
        }
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                degree[now] = time;
                for(int i = 0 ; i < map[now].size(); i++){
                    int next = map[now].get(i);
                    q.offer(next);
                }
            }
            time++;
        }
    }
}
