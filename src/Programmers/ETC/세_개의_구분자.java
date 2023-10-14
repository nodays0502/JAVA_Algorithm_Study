package Programmers.ETC;

import java.util.ArrayList;
import java.util.List;

public class 세_개의_구분자 {
    public String[] solution(String myStr) {
        int size = myStr.length();
        int prevIndex = -1;
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < size ; i++){
            char ch = myStr.charAt(i);
            if(ch == 'a' || ch == 'b' || ch == 'c'){
                if(prevIndex + 1 != i){
                    result.add(myStr.substring(prevIndex+1,i));
                }
                prevIndex = i;
            }
        }
        if(prevIndex + 1 != size){
            result.add(myStr.substring(prevIndex+1,size));
        }
        if(result.size() == 0){
            return new String[]{"EMPTY"};
        }
        String[] answer = new String[result.size()];
        for(int i = 0 ; i < result.size() ; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
