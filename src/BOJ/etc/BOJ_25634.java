package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_25634 {
    private static final int INF = 200_000 + 1;
    private static final int ON = 1;
    private static final int OFF = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        int[] onOff = new int[n];
        int min = INF;

        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
            min = Math.min(min,input[i]);
        }
        st = new StringTokenizer(br.readLine());
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            onOff[i] = stoi.apply(st.nextToken());
            if(onOff[i] == ON){
                result += input[i];
            }
        }
        int sum = 0;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            if(onOff[i] == OFF){
                sum += input[i];
            }
            if(onOff[i] == ON){
                sum -= input[i];
            }
            if(sum < 0){
                sum = 0;
            }
            max = Math.max(sum,max);
        }
        if(max == 0){
            System.out.println(result - min);
        }else{
            System.out.println(result + max);
        }
    }
}
