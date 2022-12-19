package Programmers.ETC;

import java.util.Arrays;

public class 최댓값_만들기 {
    public int solution(int[] numbers) {
        int answer = 0;
        int size = numbers.length;
        Arrays.sort(numbers);
        answer = numbers[size-1] * numbers[size-2];
        return answer;
    }
}
