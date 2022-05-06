package Programmers.ETC;

import java.util.Arrays;

public class 셔틀버스 {
    private static final int START_MIN = 9 * 60;
    private static final int MIN_IN_ONE_HOUR = 60;
    private static final int INF = MIN_IN_ONE_HOUR * 24 -1;
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        int busTime = START_MIN;
        int result = 0;
        int nowBusPeopleCnt = 0;
        int busCnt = 1;
        for(int i = 0 ; i < timetable.length ; i++){
            if(busCnt > n){
                break;
            }
            String time = timetable[i];
            int reachTime = stringToMin(time);
            // System.out.println(time+" "+reachTime+" "+busTime+" "+result+" "+busCnt+" "+nowBusPeopleCnt);
            result = Math.max(result,busTime);
            if(busTime >= reachTime){
                nowBusPeopleCnt++;
            }else{
                busTime += t;
                nowBusPeopleCnt = 0;
                i--;
                busCnt++;
                continue;
            }
            // System.out.println("m이상");
            if(nowBusPeopleCnt >= m){
                result = reachTime - 1;
                busTime += t;
                nowBusPeopleCnt = 0;
                busCnt++;
            }
            // System.out.println(reachTime+" "+busTime+" "+result);
        }

        if(result > INF){
            result = INF;
        }
        String answer = minToString(result);
        return answer;
    }
    private static int stringToMin(String str){
        String[] temp = str.split(":");
        int result = 0;
        result += Integer.parseInt(temp[0]) * MIN_IN_ONE_HOUR;
        result += Integer.parseInt(temp[1]);
        return result;
    }
    private static String minToString(int time){
        StringBuilder sb = new StringBuilder();
        int hour = time / MIN_IN_ONE_HOUR;
        int min = time % MIN_IN_ONE_HOUR;
        if(hour < 10){
            sb.append(0);
        }
        sb.append(hour).append(":");
        if(min < 10){
            sb.append(0);
        }
        sb.append(min);
        return sb.toString();
    }
}
