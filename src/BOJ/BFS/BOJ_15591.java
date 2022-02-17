package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15591 {
    private static class Node{
        int end;
        int weight;
        public Node(int end, int weight) {
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
        List<Node>[] map = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            map[a].add(new Node(b,c));
            map[b].add(new Node(a,c));
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            System.out.println(bfs(map,a,b,n));
        }
    }

    private static int bfs(List<Node>[] map, int a, int b,int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(b);
        int result = 0;
        boolean[] visited = new boolean[n+1];
        visited[b] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0 ; i < map[now].size(); i++){
                Node next = map[now].get(i);
                if(!visited[next.end] && next.weight >= a){
//                    System.out.println("next:"+next.end);
                    result++;
                    visited[next.end] = true;
                    q.offer(next.end);
                }
            }
        }
        return result;
    }
}
