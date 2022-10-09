package Programmers.ETC;

import java.util.HashSet;
import java.util.Set;

public class 콜라츠_추측 {
    private static final int NOT_FOUND = -1;
    public int solution(long num) {
        int answer = 0;
        Set<Long> visited = new HashSet<>();
        while(true){
            if(num == 1){
                break;
            }
            if(answer >= 500){
                answer = NOT_FOUND;
                break;
            }
            if(num % 2 == 0){
                num /= 2;
            }else {
                num *= 3;
                num++;
            }
            if(visited.contains(num)){
                answer = NOT_FOUND;
                break;
            }
            visited.add(num);
            answer++;
        }
        return answer;
    }
}
