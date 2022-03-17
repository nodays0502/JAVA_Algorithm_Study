package BOJ.TwoPoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14465 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] errorPoint = new int[m];
        boolean[] error = new boolean[n+1];
        for(int i = 0 ; i < m ; i++){
            int num = stoi.apply(br.readLine());
            error[num] = true;
        }
        Arrays.sort(errorPoint);
        int si = 0;
        int ei = 0;
        int result = n;
        int cnt = 0;
        for(int i = 1 ; i <= n; i++){
            if(error[i]){
                cnt++;
            }
            if(i > k){
                if(error[i-k]){
                    cnt--;
                }
            }
            if(i >= k){
                result = Math.min(result,cnt);
            }
//            System.out.println(i+" "+result);
        }
        System.out.println(result);
    }
}
