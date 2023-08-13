package Programmers.ETC;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        List<Integer>[] win = new List[n+1];
        List<Integer>[] lose = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            win[i] = new LinkedList<>();
            lose[i] = new LinkedList<>();
        }
        for(int[] result : results){
            win[result[0]].add(result[1]);
            lose[result[1]].add(result[0]);
        }
        for(int i = 1 ; i <= n ; i++){
            int cnt = 0;
            cnt += bfs(i,win,n);
            cnt += bfs(i,lose,n);
            if(cnt == n-1){
                answer++;
            }
        }
        return answer;
    }
    private static int bfs(int start, List<Integer>[] list, int n){
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        q.offer(start);
        boolean[] visited = new boolean[n+1];
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list[now]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
