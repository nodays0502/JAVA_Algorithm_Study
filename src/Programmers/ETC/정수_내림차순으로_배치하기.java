package Programmers.ETC;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기 {
    public long solution(long n) {
        long answer = 0;
        char[] charArr = Long.toString(n).toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        for(int i = charArr.length -1 ; i >= 0 ; i--){
            sb.append(charArr[i]);
        }
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
