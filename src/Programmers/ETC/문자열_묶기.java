package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 문자열_묶기 {
    public int solution(String[] strArr) {
        int answer = 0;
        Map<Integer,Integer> cnt = new HashMap<>();
        for(String str : strArr){
            cnt.merge(str.length(),1,(v1,v2) -> {
                return v1+1;
            });
        }
        for(int key : cnt.keySet()){
            answer = Math.max(answer,cnt.get(key));
        }
        return answer;
    }
}
