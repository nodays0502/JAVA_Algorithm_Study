package Programmers.ETC;

import java.util.Arrays;

public class 중앙값_구하기 {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        answer = array[array.length/2];
        return answer;
    }
}
