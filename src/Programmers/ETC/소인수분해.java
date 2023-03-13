package Programmers.ETC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 소인수분해 {
    public int[] solution(int n) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        int number = 2;
        while(n > 1){
            while(n % number == 0){
                n /= number;
                set.add(number);
            }
            number++;
        }
        answer = new int[set.size()];
        int index = 0;
        for(int temp : set) {
            answer[index++] = temp;
        }
        Arrays.sort(answer);
        return answer;
    }
}
