package Programmers.PCCP_모의고사_1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NO_4 {
    private static final int SIZE = 10;
    public long[] solution(int[][] programs) {
        // 0 - 점수
        // 1 - 호출된 시각
        // 2- 실행 시간
        long[] answer = new long[SIZE + 1];
        Arrays.sort(programs, (o1,o2) -> {
            return o1[1] - o2[1]; // 호출된 시각
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0]; // 점수
        });
        long time = 0;
        for(int i = 0 ; i < programs.length ; i++){
            int[] program = programs[i];
            if(program[1] <= time){
                pq.offer(program);
                continue;
            }else{
                i--;
            }
            if(pq.isEmpty()){
                time = program[1];
                continue;
            }
            int[] now = pq.poll();
            answer[now[0]] += (time - now[1]);
            // System.out.println(time);
            // System.out.println(Arrays.toString(now));
            // System.out.println(Arrays.toString(answer));
            time += now[2];
        }
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            answer[now[0]] += (time - now[1]);
            // System.out.println(time);
            // System.out.println(Arrays.toString(now));
            // System.out.println(Arrays.toString(answer));
            time += now[2];
        }
        answer[0] = time;
        return answer;
    }
}
