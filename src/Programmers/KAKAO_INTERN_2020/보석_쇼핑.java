package Programmers.KAKAO_INTERN_2020;

import java.util.HashMap;
import java.util.Map;

public class 보석_쇼핑 {
    public int[] solution(String[] gems) {
        int[] answer = {};
        Map<String,Integer> position = init(gems);
        int size = position.size();
        int[] kind = new int[size];
        int si = 0;
        int ei = -1;
        int resultStartIndex = 0;
        int resultEndIndex = gems.length;
        while(true){
            if(check(kind)){
                if(resultEndIndex - resultStartIndex > ei - si){
                    resultEndIndex = ei;
                    resultStartIndex = si;
                }
                int index = position.get(gems[si++]);
                kind[index]--;
                continue;
            }
            if(ei == gems.length-1){
                break;
            }
            int index = position.get(gems[++ei]);
            kind[index]++;
        }
        answer = new int[] {resultStartIndex+1, resultEndIndex+1};
        return answer;
    }
    private static boolean check(int[] kind){
        for(int cnt : kind){
            if(cnt == 0){
                return false;
            }
        }
        return true;
    }
    private static Map<String,Integer> init(String[] gems){
        Map<String,Integer> result = new HashMap<>();
        int number = 0;
        for(String gem : gems){
            if(result.containsKey(gem)){
                continue;
            }
            result.put(gem,number++);
        }
        return result;
    }
}
