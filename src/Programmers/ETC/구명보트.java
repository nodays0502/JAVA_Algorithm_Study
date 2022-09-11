package Programmers.ETC;

import java.util.Arrays;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int size = people.length;
        int minIndex = 0;
        int maxIndex = size -1;
        while(true){
            if(people[minIndex] + people[maxIndex] <= limit){
                answer++;
                minIndex++;
                maxIndex--;
            }else{
                maxIndex--;
                answer++;
            }
            if(minIndex > maxIndex){
                break;
            }
        }

        return answer;
    }
}
