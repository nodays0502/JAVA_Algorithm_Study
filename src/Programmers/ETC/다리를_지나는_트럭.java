package Programmers.ETC;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{truck_weights[0],0});
        int sum = truck_weights[0];
        int index = 1;
        while(index < truck_weights.length){
            while(!q.isEmpty() && (sum + truck_weights[index] > weight || q.size() >= bridge_length) ){
                int[] temp = q.poll();
                time = Math.max(temp[1] + bridge_length,time);
                sum -= temp[0];
            }
            sum += truck_weights[index];
            q.offer(new int[]{truck_weights[index],time});
            time++;
            index++;
        }
        while(!q.isEmpty()){
            int[] temp = q.poll();
            time = temp[1] + bridge_length;
        }
        answer = time + 1;
        return answer;
    }
}
