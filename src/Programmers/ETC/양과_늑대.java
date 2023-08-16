package Programmers.ETC;

import java.util.ArrayList;
import java.util.List;

public class 양과_늑대 {
    private static final int WOLF = 1;
    private static final int SHEEP = 0;
    public int solution(int[] info, int[][] edges) {
        int size = info.length;
        List<Integer>[] map = new List[size];
        for(int i = 0 ; i < size ; i++){
            map[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int start = edge[0];
            int end = edge[1];
            map[start].add(end);
        }
        int answer = cal(0,0,0,info,map,new ArrayList<>());
        return answer;
    }
    private static int cal(int now,int sheep,int wolf,int[] info, List<Integer>[] map, List<Integer> list){
        if(info[now] == SHEEP){
            sheep++;
        }else{
            wolf++;
        }
        if(wolf >= sheep){
            return 0;
        }
        int result = sheep;
        List<Integer> temp = new ArrayList<>();
        for(int next : map[now]){
            temp.add(next);
        }
        for(int next : list){
            if(next == now){
                continue;
            }
            temp.add(next);
        }
        for(int next : temp){
            result = Math.max(result,cal(next,sheep,wolf,info,map,temp));
        }
        return result;
    }
}
