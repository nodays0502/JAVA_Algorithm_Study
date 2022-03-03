package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10159 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int m = stoi.apply(br.readLine());
        List<Integer>[] lighter = new ArrayList[n+1];
        List<Integer>[] heavier = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++){
            lighter[i] = new ArrayList<>();
            heavier[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            String[] temp = br.readLine().split(" ");
            int a = stoi.apply(temp[0]);
            int b = stoi.apply(temp[1]);
            lighter[a].add(b);
            heavier[b].add(a);
        }
        int[] lighterCnt = new int[n+1];
        int[] heavierCnt = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            bfs(i,lighter,lighterCnt,n);
            bfs(i,heavier,heavierCnt,n);
        }
        for(int i = 1 ; i <= n ; i++){
            System.out.println( n-1 - lighterCnt[i] - heavierCnt[i]);
        }
    }

    private static void bfs(int start,List<Integer>[] map, int[] cnt, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(start);
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0 ; i < map[now].size() ; i++){
                int next = map[now].get(i);
                if(!visited[next]){
                    cnt[next]++;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}
