package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2018_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int result = cal(n);
        System.out.println(result);
    }
    private static int cal(int n) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;
        while(true){
            if(end > n){
                break;
            }
            if(sum == n){
                cnt++;
            }
            if(sum >= n){
                sum -= ++start;
            }else{
                sum += ++end;
            }
        }
        return cnt;
    }
}


