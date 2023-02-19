package Programmers.ETC;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 숫자_변환하기 {
    private static final int NOT_FOUND = -1;
    public int solution(int x, int y, int n) {
        int answer = cal(x,y,n);
        return answer;
    }
    private static int cal(int start,int end , int num){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int time = 0;
        Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                if(now == end){
                    return time;
                }
                int next = 0;
                for(int i = 1 ; i <= 3 ; i++){
                    if(i == 1){
                        next = now + num;
                    }else{
                        next = now * i;
                    }
                    if(!visited.contains(next) && next <= end){
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            time++;
        }
        return NOT_FOUND;
    }
}
