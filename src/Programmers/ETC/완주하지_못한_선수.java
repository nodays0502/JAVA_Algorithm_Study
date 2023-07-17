package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> peoples = new HashMap<>();
        for(String people : participant){
            peoples.merge(people,1,(v1,v2) ->{
                return v1 + 1;
            });
        }
        for(String people : completion){
            peoples.merge(people,0,(v1,v2) ->{
                return v1 - 1;
            });
        }
        for(String key : peoples.keySet()){
            if(peoples.get(key) != 0){
                answer = key;
                break;
            }
        }
        return answer;
    }
}
