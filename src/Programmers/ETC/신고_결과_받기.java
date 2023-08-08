package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int size = id_list.length;
        int[] answer = new int[size];
        boolean[][] reportArr = new boolean[size][size];
        Map<String,Integer> map = makeMap(id_list);
        for(String str : report){
            String[] temp = str.split(" ");
            int first = map.get(temp[0]);
            int second = map.get(temp[1]);
            reportArr[first][second] = true;
        }
        boolean[] isBlock = new boolean[size];
        for(int i = 0 ; i < size ; i++){
            int cnt = 0;
            for(int j = 0 ; j < size ; j++){
                if(reportArr[j][i]){
                    cnt++;
                }
            }
            if(cnt >= k){
                isBlock[i] = true;
            }
        }
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(isBlock[j] && reportArr[i][j]){
                    answer[i]++;
                }
            }
        }
        return answer;
    }
    private static Map<String,Integer> makeMap(String[] id_list){
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < id_list.length ; i++){
            map.put(id_list[i],i);
        }
        return map;
    }
}
