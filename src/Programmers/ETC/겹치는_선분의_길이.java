package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 겹치는_선분의_길이 {
    public int solution(int[][] lines) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int[] line : lines){
            int start = line[0];
            int end = line[1];
            for(int i = start ; i < end ; i++){
                map.merge(i,1,(v1,v2)->v1+1);
            }
        }
        boolean flag = false;
        int prev = -100;
        for(int i = -100 ; i <= 100 ; i++){
            int cnt = map.getOrDefault(i,0);
            if(cnt == 0 || cnt == 1){
                if(flag){
                    flag = false;
                    answer += i - prev;
                }
                continue;
            }else{
                if(!flag){
                    prev = i;
                }
                flag = true;
            }
        }
        if(flag){
            answer += 100 - prev;
        }
        return answer;
    }
}
