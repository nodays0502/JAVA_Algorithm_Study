package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 주차_요금_계산 {
    private static final int LAST_TIME = changeStringToMin("23:59");
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<Integer,Integer> carTime = new HashMap<>();
        Map<Integer,Integer> carInTime = new HashMap<>();
        for(String record : records){
            String[] str = record.split(" ");
            int min = changeStringToMin(str[0]);
            int carNum = Integer.parseInt(str[1]);
            if(str[2].equals("IN")){
                carInTime.put(carNum,min);
            }else{
                int prevMin = carInTime.get(carNum);
                int time = min - prevMin;
                carTime.merge(carNum,time,(v1,v2)->{
                    return v1 + time;
                });
                carInTime.remove(carNum);
            }
        }
        for(int carNum : carInTime.keySet()){
            int prevMin = carInTime.get(carNum);
            int time = LAST_TIME - prevMin;
            carTime.merge(carNum,time,(v1,v2)->{
                return v1 + time;
            });

        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1,v2)->{
            return v1[0] - v2[0];
        });
        for(int carNum : carTime.keySet()){
            int fee = calFee(carTime.get(carNum),fees);
            pq.offer(new int[]{carNum,fee});
        }
        answer = new int[pq.size()];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = pq.poll()[1];
        }
        return answer;
    }
    private static int calFee(int time , int[] fees){
        if(time <= fees[0]){
            return fees[1];
        }
        int temp = time - fees[0];
        if(temp % fees[2] != 0){
            temp /= fees[2];
            temp++;
        }else{
            temp /= fees[2];
        }
        return fees[1] + temp * fees[3];
    }
    private static int changeStringToMin(String s){
        String[] str = s.split(":");
        int result = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        return result;
    }
}
