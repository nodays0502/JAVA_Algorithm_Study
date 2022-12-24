package Programmers.ETC;

import java.util.LinkedList;
import java.util.List;

public class 약수_구하기 {
    public int[] solution(int n) {
        int[] answer = cal(n);
        return answer;
    }
    private int[] cal(int num){
        List<Integer> list = new LinkedList<>();
        for(int i = 1 ; i <= num ; i++){
            if(num % i == 0){
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
