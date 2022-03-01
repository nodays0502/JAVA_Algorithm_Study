package BOJ.TwoPoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2230 {
    private static int cal(int[] input,int n, int m){
        int si = 0;
        int ei = 1;
        int result = 1_000_000_000 * 2 ;
        while(ei < n){
            int diff = input[ei] - input[si];
            if(diff >= m){
                result = Math.min(result, diff);
                if(si < ei){
                    si++;
                }else{
                    ei++;
                }
            }else{
                ei++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(br.readLine());
        }
        Arrays.sort(input);
        System.out.println(cal(input,n,m));
    }
}
