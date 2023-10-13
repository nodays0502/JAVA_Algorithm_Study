package Programmers.ETC;

import java.util.ArrayList;
import java.util.List;

public class x_사이의_개수 {
    public int[] solution(String myString) {
        System.out.println(myString);
        int prevIndex = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < myString.length() ; i++){
            char ch = myString.charAt(i);
            if(ch == 'x'){
                result.add(i - prevIndex);
                prevIndex = i+1;
            }
        }
        result.add(myString.length() - prevIndex);
        int[] answer = new int[result.size()];
        for(int i = 0 ; i < result.size() ; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
