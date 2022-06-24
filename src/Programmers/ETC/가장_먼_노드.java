package Programmers.ETC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장_먼_노드 {
    private static final int START  = 0;
    private static final int END  = 1;
    private static final int START_POSITION  = 1;
    public int solution(int n, int[][] edges) {
        int answer = 0;
        List<Integer>[] map = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            map[edge[START]].add(edge[END]);
            map[edge[END]].add(edge[START]);
        }

        answer = bfs(map,n);
        return answer;
    }
    private static int bfs(List<Integer>[] map, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(START_POSITION);
        boolean[] visited = new boolean[n+1];
        visited[START_POSITION] = true;
        int result = 0;
        while(!q.isEmpty()){
            int size = q.size();
            result = size;
            for(int i = 0 ; i < size ; i++){
                int now = q.poll();
                for(int next : map[now]){
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
        return result;
    }
}
