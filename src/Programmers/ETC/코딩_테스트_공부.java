package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 코딩_테스트_공부 {

    private static final int alp_req_INDEX = 0;
    private static final int cop_req_INDEX = 1;
    private static final int alp_rwd_INDEX = 2;
    private static final int cop_rwd_INDEX = 3;
    private static final int cost_INDEX = 4;
    private static final int NOT_FOUND = -1;

    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxAlp = 0;
        int maxCop = 0;
        for(int[] problem : problems){
            maxAlp = Math.max(maxAlp,problem[0]);
            maxCop = Math.max(maxCop,problem[1]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1,v2)->{
            return v1[2] - v2[2];
        });
        Map<String,Integer> map = new HashMap<>();
        pq.offer(new int[]{alp,cop,0});
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[0] >= maxAlp && now[1] >= maxCop){
                return now[2];
            }
            if(now[0] < maxAlp){
                int[] next = new int[]{now[0]+1,now[1],now[2]+1};
                if(!map.containsKey(changeArrayToString(next)) || map.get(changeArrayToString(next)) > now[2]+1){
                    pq.offer(next);
                    map.put(changeArrayToString(next),now[2]+1);
                }
            }
            if(now[1] < maxCop){
                int[] next = new int[]{now[0],now[1]+1,now[2]+1};
                if(!map.containsKey(changeArrayToString(next)) || map.get(changeArrayToString(next)) > now[2]+1){
                    pq.offer(next);
                    map.put(changeArrayToString(next),now[2]+1);
                }
            }
            for(int[] problem : problems){
                if(now[0] < problem[alp_req_INDEX] || now[1] < problem[cop_req_INDEX]){
                    continue;
                }
                int[] next = new int[]{now[0] + problem[alp_rwd_INDEX],now[1] +problem[cop_rwd_INDEX],now[2] + problem[cost_INDEX]};
                if(!map.containsKey(changeArrayToString(next)) || map.get(changeArrayToString(next)) > now[2]+problem[cost_INDEX]){
                    pq.offer(next);
                    map.put(changeArrayToString(next),now[2]+problem[cost_INDEX]);
                }
            }
        }
        return NOT_FOUND;
    }
    private static String changeArrayToString(int[] arr){
        return "{" + arr[0] + "," + arr[1] + "}";
    }
}
