package Programmers.ETC;

import java.util.Arrays;

public class 가장_가까운_같은_글자 {
    private static final int SIZE = 26;
    public int[] solution(String s) {
        int sSize = s.length();
        int[] answer = new int[sSize];
        int[] index = new int[SIZE];
        Arrays.fill(index, -1);
        for(int i = 0 ; i < sSize ; i++){
            char ch = s.charAt(i);
            int chIndex = ch - 'a';
            if(index[chIndex] == -1){
                answer[i] = -1;
            }else{
                answer[i] = i - index[chIndex];
            }
            index[chIndex] = i;
        }
        return answer;
    }
}
