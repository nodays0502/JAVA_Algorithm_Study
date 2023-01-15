package Programmers.ETC;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 귤_고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> cnt = new HashMap<>();
        Set<Integer> used = new HashSet<>();
        for(int kg : tangerine){
            cnt.merge(kg,1,(v1,v2)->v1+1);
        }
        List<Integer> list = new LinkedList<>();
        for(int key : cnt.keySet()){
            list.add(cnt.get(key));
        }
        Collections.sort(list);
        int sum = 0;
        for(int i = list.size() - 1 ; i >= 0 ; i--){
            int tempCnt = list.get(i);
            sum += tempCnt;
            answer++;
            if(sum >= k){
                break;
            }
        }
        return answer;
    }
}
