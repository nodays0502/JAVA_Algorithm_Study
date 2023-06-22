package Programmers.ETC;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {

        Map<String,Integer> map = new HashMap<>();
        Map<Integer,Integer> score = new HashMap<>();
        int num = 0;


        for(int i = 0 ; i < genres.length ; i++){
            String genre = genres[i];
            int play = plays[i];
            if(!map.containsKey(genre)){
                map.put(genre,num++);
                score.put(map.get(genre),play);
            }else{
                score.merge(map.get(genre),play,(v1,v2)->{
                    return v1+v2;
                });
            }


        }
        int size = num;
        PriorityQueue<int[]>[] pq = new PriorityQueue[size];
        for(int i = 0 ; i < size ; i++){
            pq[i] = new PriorityQueue<>((v1,v2)->{
                if(v1[1] == v2[1]){
                    return v1[0] - v2[0];
                }
                return v2[1] - v1[1];
            });
        }
        for(int i = 0 ; i < genres.length ; i++){
            int index = map.get(genres[i]);
            pq[index].add(new int[]{i, plays[i]});
        }
        PriorityQueue<int[]> scorePq = new PriorityQueue<>((v1,v2)->{
            return v2[1] - v1[1];
        });
        for(int key : score.keySet()){
            scorePq.add(new int[]{key,score.get(key)});
        }
        List<Integer> list = new LinkedList<>();
        while(!scorePq.isEmpty()){
            int index = scorePq.poll()[0];
            for(int i = 0 ; i < 2; i++){
                if(pq[index].isEmpty()){
                    break;
                }
                list.add(pq[index].poll()[0]);
            }
        }
        System.out.println(list);
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
