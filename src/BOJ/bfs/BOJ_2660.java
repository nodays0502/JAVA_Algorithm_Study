package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2660 {
    private static int bfs(List<Integer>[] map, int start, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[n+1];
        int time = -1;
        visited[start] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                for(int i = 0 ; i < map[now].size(); i++){
                    int next = map[now].get(i);
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            time++;
        }
        return time;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        List[] map = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            if(a == -1 && b == -1){
                break;
            }
            map[a].add(b);
            map[b].add(a);
        }
        int min = 1_000;
        int[] score = new int[n+1];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n ; i++){
            score[i] = bfs(map, i, n);
            min = Math.min(min,score[i]);
        }
        int cnt = 0;
        for(int i = 1; i <= n ; i++){
            if(score[i] == min){
                cnt++;
                sb.append(i+" ");
            }
        }
        System.out.println(min +" "+cnt);
        System.out.println(sb.toString());
    }
}
