package Programmers.ETC;

import java.util.Arrays;

public class 특이한_정렬 {
    private static int value = 0;
    public int[] solution(int[] numlist, int n) {
        int size = numlist.length;
        value = n;
        int[] answer = new int[size];
        boolean[] used = new boolean[size];
        for(int i = 0 ; i < size ; i++){
            int index = -1;
            for(int j = 0 ; j < size ; j++){
                if(used[j]){
                    continue;
                }
                if(index == -1){
                    index = j;
                    continue;
                }
                int prev = numlist[index];
                int now = numlist[j];
                if(Math.abs(n-prev) > Math.abs(n-now)){
                    index = j;
                    continue;
                }
                if(Math.abs(n-prev) == Math.abs(n-now) && prev < now){
                    index = j;
                }
            }
            used[index] = true;
            answer[i] = numlist[index];
        }

        return answer;
    }
}
