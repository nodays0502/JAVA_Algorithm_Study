package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_22864 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int fatigue = stoi.apply(st.nextToken());
        int work = stoi.apply(st.nextToken());
        int rest = stoi.apply(st.nextToken());
        int maxFatigue = stoi.apply(st.nextToken());
        int result = 0;
        int nowFatigue = 0;
        for(int time = 0 ; time < 24 ; time++){
            if(nowFatigue + fatigue <= maxFatigue){
                nowFatigue += fatigue;
                result += work;
            }else{
                nowFatigue = Math.max(nowFatigue - rest,0);
            }
        }
        System.out.println(result);
    }
}
