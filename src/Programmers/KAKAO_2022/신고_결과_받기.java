package Programmers.KAKAO_2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class 신고_결과_받기 {
    private static void init(Map<String,Integer>map , String[] id_list){
        for(int i = 0 ; i < id_list.length ; i++){
            map.put(id_list[i],i);
        }
    }
    private static int[] cal(Set<Integer>[] isCheckReportor,
        Map<String,Integer>map,
        String[] report,
        List<Integer>[] reports,
        int size,
        int k){
        for(String res:report){
            String[] temp = res.split(" ");
            int reportIndex = map.get(temp[0]);
            int reportedIndex = map.get(temp[1]);
            if(isCheckReportor[reportedIndex].add(reportIndex)){
                reports[reportedIndex].add(reportIndex);
            }
        }
        int[] answer = new int[size];
        for(int i = 0 ; i < size ; i++){
            if(isCheckReportor[i].size() >= k){
                for(int j = 0 ; j < reports[i].size(); j++){
                    int index = reports[i].get(j);
                    answer[index]++;
                }
            }
        }
        return answer;
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        int size = id_list.length;
        int[] answer = new int[size];
        Map<String,Integer> map = new HashMap<>();
        init(map,id_list);
        Set<Integer>[] isCheckReportor = new HashSet[size];
        List<Integer>[] reports = new ArrayList[size];
        for(int i = 0 ; i < size; i++){
            isCheckReportor[i] = new HashSet<>();
            reports[i] = new ArrayList<>();
        }
        answer = cal(isCheckReportor,map,report,reports,size,k);

        return answer;
    }
}
