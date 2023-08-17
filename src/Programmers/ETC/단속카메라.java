package Programmers.ETC;

import java.util.Arrays;

public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(v1,v2)->{
            return v1[1] - v2[1];
        });
        System.out.println(Arrays.deepToString(routes));
        int position = -40_000;
        for(int[] route : routes){
            if(route[0] > position || route[1] < position){
                answer++;
                position = route[1];
            }
        }
        return answer;
    }
}
