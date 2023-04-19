package Programmers.ETC;

import java.util.Arrays;

public class 요격_시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(v1,v2)->{
            if(v1[0] == v2[0]){
                return v1[1] - v2[1];
            }
            return v1[0] - v2[0];
        });
        int start = 0;
        int end = 0;
        for(int[] target : targets){
            int tempStart = target[0];
            int tempEnd = target[1];
            if(tempStart >= start && tempStart < end){
                end = Math.min(tempEnd,end);
                start = Math.min(tempStart,start);
            }else{
                answer++;
                start = tempStart;
                end = tempEnd;
            }
        }
        // System.out.println(Arrays.deepToString(targets));
        return answer;
    }
}
