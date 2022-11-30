package Programmers.ETC;

import java.util.Set;

public class 배열의_유사도 {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        for(String str : s1){
            set.add(str);
        }
        for(String str : s2){
            if(set.contains(str)){
                answer++;
            }
        }
        return answer;
    }
}
