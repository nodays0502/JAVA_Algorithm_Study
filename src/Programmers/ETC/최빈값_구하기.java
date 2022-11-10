package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 최빈값_구하기 {
    private static final int NOT_FOUND = -1;
    public int solution(int[] array) {
        int answer = NOT_FOUND;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : array){
            map.merge(num,1,(v1,v2)->v1+1);
        }
        int maxCnt = 0;
        int result = 0;
        boolean flag = false;
        for(int num : map.keySet()){
            if(map.get(num) == maxCnt){
                flag = true;
            }
            if(map.get(num) > maxCnt){
                flag = false;
                maxCnt = map.get(num);
                result = num;
            }
        }
        if(!flag){
            answer = result;
        }
        return answer;
    }
}
