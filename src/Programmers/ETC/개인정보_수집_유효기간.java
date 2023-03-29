package Programmers.ETC;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 개인정보_수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list = new LinkedList<>();
        Map<Character,Integer> term = new HashMap<>();
        for(String str : terms){
            String[] temp = str.split(" ");
            char ch = temp[0].charAt(0);
            int month = Integer.parseInt(temp[1]);
            term.put(ch,month);
        }
        for(int i = 0 ; i < privacies.length ; i++){
            String privacy = privacies[i];
            if(check(today,privacy,term)){
                list.add(i+1);
            }
        }
        answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        System.out.println(list);
        return answer;
    }
    private static boolean check(String todayStr,String str , Map<Character,Integer> map){
        int today = strToDay(todayStr);
        String[] temp = str.split(" ");
        int day = strToDay(temp[0]);
        char type = temp[1].charAt(0);
        int period = map.get(type) * DAY_IN_MONTH;
        if(today >= day + period){
            return true;
        }
        return false;
    }
    private static final int DAY_IN_MONTH = 28;
    private static final  int DAY_IN_YEAR = DAY_IN_MONTH * 12;
    private static int strToDay(String str){
        String[] temp = str.split("\\.");
        int result = 0;
        result += Integer.parseInt(temp[0]) * DAY_IN_YEAR;
        result += Integer.parseInt(temp[1]) * DAY_IN_MONTH;
        result += Integer.parseInt(temp[2]);
        return result;
    }
}
