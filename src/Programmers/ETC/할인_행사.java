package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 할인_행사 {
    private static final int MEMBER_PERIOD = 10;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        int index = 0;
        for(String str : want){
            map.put(str,index++);
        }
        for(int i = 0 ; i < discount.length ; i++){
            if(i >= MEMBER_PERIOD){
                index = map.getOrDefault(discount[i - MEMBER_PERIOD],-1);
                if(index != -1){
                    number[index]++;
                }
            }
            String str  = discount[i];
            index = map.getOrDefault(str,-1);
            if(index != -1){
                number[index]--;
            }
            if(checkNumber(number)){
                answer++;
            }
        }
        return answer;
    }
    private boolean checkNumber(int[] number){
        for(int num : number){
            if(num > 0){
                return false;
            }
        }
        return true;
    }
}
