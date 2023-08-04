package Programmers.ETC;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class 등산코스_정하기 {
    private static final int NOT_VISITED = -1;
    private static final int INF = 987654321;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[]{n,INF};
        boolean[] isFinish = new boolean[n+1];
        for(int summit : summits){
            isFinish[summit] = true;
        }
        List<int[]>[] list = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            list[i] = new LinkedList<>();
        }
        for(int[] path : paths){
            list[path[0]].add(new int[]{path[1],path[2]});
            list[path[1]].add(new int[]{path[0],path[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1,v2)->{
            if(v1[1] == v2[1]){
                return v1[0] - v2[0];
            }
            return v1[1] - v2[1];
        });
        int[] visited = new int[n+1];
        Arrays.fill(visited,NOT_VISITED);
        for(int gate: gates){
            pq.offer(new int[]{gate,0});
            visited[gate] = 0;
        }
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            // System.out.println(Arrays.toString(now));
            if(isFinish[now[0]]){
                if(answer[1] > now[1]){
                    answer = now;
                }else if(answer[1] == now[1] && answer[0] > now[0]){
                    answer = now;
                }
                continue;
            }
            if(answer[1] < now[1]){
                break;
            }
            for(int[] next : list[now[0]]){
                int temp = Math.max(next[1], now[1]);
                if(visited[next[0]] != NOT_VISITED && visited[next[0]] <= temp ){
                    continue;
                }
                pq.offer(new int[]{next[0],temp});
                visited[next[0]] = temp;
            }
        }
        return answer;
    }
}
