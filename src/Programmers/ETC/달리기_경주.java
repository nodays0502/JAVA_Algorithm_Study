package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 달리기_경주 {
    public String[] solution(String[] players, String[] callings) {
        int size = players.length;
        Map<String,Integer> findIndex = new HashMap<>();
        for(int i = 0 ; i < size ; i++){
            findIndex.put(players[i],i);
        }
        for(String call : callings){
            int nowIndex = findIndex.get(call);
            int prevIndex = findIndex.get(players[nowIndex-1]);
            String temp = players[prevIndex];
            players[prevIndex] = players[nowIndex];
            players[nowIndex] = temp;
            findIndex.put(players[prevIndex],prevIndex);
            findIndex.put(players[nowIndex],nowIndex);
        }
        String[] answer = players;
        return answer;
    }
}
