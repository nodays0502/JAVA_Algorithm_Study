package Programmers.ETC;

import java.util.LinkedList;
import java.util.List;

public class 콜라츠_수열_만들기 {
    public int[] solution(int n) {
        int[] answer = cal(n);
        return answer;
    }
    private static int[] cal(int n){
        List<Integer> list = new LinkedList<>();
        list.add(n);
        while(n != 1){
            if(n % 2 == 0){
                n /= 2;
            }else{
                n = 3 * n + 1;
            }
            list.add(n);
        }
        int[] result = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
