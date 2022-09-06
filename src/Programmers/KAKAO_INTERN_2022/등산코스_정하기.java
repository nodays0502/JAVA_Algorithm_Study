package Programmers.KAKAO_INTERN_2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class 등산코스_정하기 {
    private static final int INF = 987654321;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        List<int[]>[] map = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new LinkedList<>();
        }
        for(int[] path : paths){
            map[path[0]].add(new int[] {path[1],path[2]});
            map[path[1]].add(new int[] {path[0],path[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        Set<Integer> stop = new HashSet<>();
        Map<Integer,Integer> visited = new HashMap<>();
        for(int gate : gates){
            pq.offer(new int[] {gate,0});
            visited.put(gate,0);
        }
        for(int summit : summits){
            stop.add(summit);

        }
        int minValue = INF;
        int minSummit = INF;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(minValue < now[1]){
                break;
            }
            if(stop.contains(now[0])){
                minValue = now[1];
                minSummit = Math.min(minSummit, now[0]);
                answer = new int[] {minSummit, minValue};
                continue;
            }
            for(int[] path : map[now[0]]){
                int[] next = new int[]{path[0],Math.max(now[1],path[1])};
                if(visited.getOrDefault(next[0],INF) > next[1]){
                    visited.put(next[0],next[1]);
                    pq.offer(next);
                }
            }
        }
        return answer;
    }
}
