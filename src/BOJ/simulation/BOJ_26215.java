package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_26215 {
    private static final int LIMIT = 1440;
    private static final int ERROR = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            num[i] = stoi.apply(st.nextToken());
            sum += num[i];
            max = Math.max(max,num[i]);
        }
        int remain = sum - max;
        int result = sum / 2;
        if(sum % 2 != 0){
            result++;
        }
        if(max > remain){
            result = max;
        }
        if(result > LIMIT){
            System.out.println(ERROR);
        }else{
            System.out.println(result);
        }
    }
}
