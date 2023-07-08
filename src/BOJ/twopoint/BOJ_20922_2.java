package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_20922_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        int result = cal(input,n,k);
        System.out.println(result);
    }
    private static final int MAX_VALUE = 100_000;
    private static int cal(int[] input, int n, int k) {
        int[] cnt = new int[MAX_VALUE + 1];
        int si = 0;
        int ei = 0;
        int result = 0;
        while(true){
            if(ei == n){
                break;
            }
            int now = input[ei++];
            cnt[now]++;
            while(cnt[now] > k){
                cnt[input[si++]]--;
            }
            result = Math.max(result, ei - si);
        }
        return result;
    }
}
