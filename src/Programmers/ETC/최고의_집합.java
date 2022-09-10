package Programmers.ETC;

import java.util.Arrays;

public class 최고의_집합 {
    public int[] solution(int n, int s) {
        if(n > s){
            return new int[] {-1};
        }
        int[] answer = new int[n];
        int div = s / n;
        int revider = s % n;
        for(int i = 0 ; i < n ; i++){
            answer[i] = div;
            if(revider > 0){
                answer[i]++;
                revider--;
            }
        }
        Arrays.sort(answer);
        return answer;
    }
}
