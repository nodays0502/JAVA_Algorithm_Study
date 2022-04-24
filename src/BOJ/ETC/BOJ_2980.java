package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2980 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int l = stoi.apply(st.nextToken());
        int time = 0;
        int distance = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int position = stoi.apply(st.nextToken());
            time += (position - distance);
            distance = position;
            int redLightTime = stoi.apply(st.nextToken());
            int greenLightTime = stoi.apply(st.nextToken());
            time =  crossLight(time,redLightTime,greenLightTime);
        }
        time += (l-distance);
        System.out.println(time);
    }
    private static int crossLight(int time,int redLightTime,int greenLightTime){
        int totalCycleTime = redLightTime + greenLightTime;
        int divide = time / totalCycleTime;
        int restTime = time - divide * totalCycleTime;
        if(restTime <= redLightTime){
            return time + redLightTime - restTime;
        }
        return time;
    }
}
