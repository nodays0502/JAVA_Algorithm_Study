package Programmers.KAKAO_INTERN_2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 코딩_테스트_공부 {
    private static final int alp_req_index = 0;
    private static final int cop_req_index = 1;
    private static final int alp_rwd_index = 2;
    private static final int cop_rwd_index = 3;
    private static final int cost_index = 4;

    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxAlp = 0;
        int maxCop = 0;
        for(int[] problem : problems){
            maxAlp = Math.max(maxAlp,problem[alp_req_index]);
            maxCop = Math.max(maxCop,problem[cop_req_index]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        pq.offer(new int[] {alp,cop,0});
        Set<String> visited = new HashSet<>();
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[0] >= maxAlp && now[1] >= maxCop){
                answer = now[2];
                break;
            }
            int[] next = new int[] {now[0]+1, now[1], now[2]+1};
            if(!visited.contains(Arrays.toString(next))){
                visited.add(Arrays.toString(next));
                pq.offer(next);
            }
            next = new int[] {now[0], now[1]+1, now[2]+1};
            if(!visited.contains(Arrays.toString(next))){
                visited.add(Arrays.toString(next));
                pq.offer(next);
            }
            for(int[] problem : problems){
                if(now[0] >= problem[alp_req_index] && now[1] >= problem[cop_req_index]){
                    next = new int[] {now[0] + problem[alp_rwd_index],now[1] + problem[cop_rwd_index],
                        now[2]+problem[cost_index]};
                    if(!visited.contains(Arrays.toString(next))){
                        visited.add(Arrays.toString(next));
                        pq.offer(next);
                    }
                }
            }
        }
        return answer;
    }
}
