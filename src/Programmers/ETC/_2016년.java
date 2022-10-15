package Programmers.ETC;

public class _2016년 {
    private static final int[] DAT_IN_MONTH = {
        0,
        31,29,31,30,
        31,30,31,31,
        30,31,30,31
    };
    private static final String[] DAY = {
        "THU", "FRI", "SAT" , "SUN", "MON", "TUE", "WED"
    };
    public String solution(int a, int b) {
        String answer = "";
        int day = 0;
        for(int i = 1 ; i < a ; i++){
            day += DAT_IN_MONTH[i];
        }
        day += b;
        day %= 7;
        answer = DAY[day];
        return answer;
    }
}
