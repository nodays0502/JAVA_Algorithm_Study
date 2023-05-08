package Programmers.ETC;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 배열_만들기 {
    public int[] solution(int l, int r) {
        int[] answer = cal(l,r);
        return answer;
    }
    private static int[] cal(int l,int r){
        List<Integer> result = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(5);
        while(!q.isEmpty()){
            int num = q.poll();
            if(num >= l && num <= r){
                result.add(num);
            }
            if(num > r){
                continue;
            }
            q.offer(num * 10);
            q.offer(num * 10 + 5);
        }
        if(result.size() == 0){
            return new int[]{-1};
        }
        int[] temp = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++){
            temp[i] = result.get(i);
        }
        return temp;
    }
}
