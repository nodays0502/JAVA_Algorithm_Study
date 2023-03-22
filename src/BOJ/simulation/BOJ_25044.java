package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_25044 {
    private static final int MIN_OF_HOUR = 60;
    private static final int HOUR_OF_DAY = 24;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        cal(n,k);
    }
    private static int calMin(int hour){
        return hour * MIN_OF_HOUR;
    }
    private static String minToString(int time){
        StringBuilder sb = new StringBuilder();
        int hour = time / MIN_OF_HOUR;
        int min = time % MIN_OF_HOUR;
        hour %= 24;
        if(hour < 10){
            sb.append(0);
        }
        sb.append(hour);
        sb.append(":");
        if(min < 10){
            sb.append(0);
        }
        sb.append(min);
        return sb.toString();
    }
    private static int[] TIME_TERM = {3 * MIN_OF_HOUR, 3 * MIN_OF_HOUR , 18 * MIN_OF_HOUR};
    private static void cal(int n, int k) {
        int min = calMin(15);
        int today = calMin(n * HOUR_OF_DAY);
        int tomorrow = calMin((n+1) * HOUR_OF_DAY);
        List<Integer> result = new LinkedList<>();
        int cnt = 0;
        while(min < tomorrow){
            if(today <= min){
                result.add(min);
            }
            min += TIME_TERM[cnt % 3];
            cnt++;
            if(cnt % 3 == 0){
                min += k;
            }
        }
        System.out.println(result.size());
        for(int i = 0 ; i < result.size() ; i++){
            System.out.println(minToString(result.get(i)));
        }
    }
}
