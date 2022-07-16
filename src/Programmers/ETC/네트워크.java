package Programmers.ETC;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                findNetwork(i,computers,visited,n);
                answer++;
            }
        }
        return answer;
    }
    private static final int CONNECTED = 1;
    private void findNetwork(int position, int[][] computers, boolean[] visited, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(position);
        visited[position] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0 ; i < n ; i++){
                if(!visited[i] && computers[now][i] == CONNECTED){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
