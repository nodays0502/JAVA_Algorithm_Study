package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14501 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] period = new int[n];
        int[] value = new int[n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            period[i] = stoi.apply(st.nextToken());
            value[i] = stoi.apply(st.nextToken());
        }
        int result = cal(0,period,value,n);
        System.out.println(result);
    }

    private static int cal(int depth, int[] period, int[] value,int n) {
        if(depth >= n){
            return 0;
        }
        int result = 0;
        if(depth + period[depth] <= n){
            result = Math.max(cal(depth+period[depth],period,value,n)+value[depth],result);
        }
        result = Math.max(cal(depth+1,period,value,n),result);
        return result;
    }
}
