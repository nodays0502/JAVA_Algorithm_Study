package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2852 {
    private static final int LAST_TIME = 60 * 48;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] score = new int[3];
        int[] totalTime = new int[3];
        int prevTime = 0;
        for(int i = 0 ; i <= n ; i++){
            int min = LAST_TIME;
            int team = 1;
            if(i != n){
                StringTokenizer st = new StringTokenizer(br.readLine());
                team = stoi.apply(st.nextToken());
                String time = st.nextToken();
                min = 60 * stoi.apply(time.split(":")[0]);
                min += stoi.apply(time.split(":")[1]);
            }
            if(score[1] < score[2]){
                totalTime[2] += min - prevTime;
            }
            if(score[1] > score[2]){
                totalTime[1] += min - prevTime;
            }
            score[team]++;
            prevTime = min;
        }
        System.out.println(minToString(totalTime[1]));
        System.out.println(minToString(totalTime[2]));
    }
    private static String minToString(int time){
        StringBuilder sb = new StringBuilder();
        int hour = time / 60;
        if(hour < 10){
            sb.append("0");
        }
        sb.append(hour+":");
        int min = time % 60;
        if(min < 10){
            sb.append("0");
        }
        sb.append(min);
        return sb.toString();
    }
}
