package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18511 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] number = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < k ; i++){
            number[i] = stoi.apply(st.nextToken());
        }
        int result = cal(0,number,k,n);
        System.out.println(result);
    }

    private static int cal(int now, int[] number, int k, int n) {
        int result = now;
        for(int i = k-1 ; i >= 0 ; i--){
            int next = now * 10 + number[i];
            if(next <= n){
                result = Math.max(result,cal(next,number,k,n));
            }
        }
        return result;
    }
}
