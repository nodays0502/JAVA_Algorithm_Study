package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][n+1];
        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map[start][end] = weight;
            map[end][start] = weight;
        }
        int result = cal(map,n);
        System.out.println(result);
    }

    private static int cal(int[][] map, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1,v2)->{
            return v1[1] - v2[1];
        });
        pq.offer(new int[]{1,0});
        int result = 0;
        boolean[] visited = new boolean[n + 1];
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(visited[now[0]]){
                continue;
            }
            visited[now[0]] = true;
            int length = now[1];
            result += length;
            for(int i = 1 ; i <= n ; i++){
                if(!visited[i] && map[now[0]][i] != 0){
                    pq.offer(new int[]{i,map[now[0]][i]});
                }
            }
        }
        return result;
    }
}
