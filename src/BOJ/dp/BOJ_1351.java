package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1351 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Long> stoi = Long::parseLong;
        long n = stoi.apply(st.nextToken());
        long p = stoi.apply(st.nextToken());
        long q = stoi.apply(st.nextToken());
//        long[] dp = new long[n+1];
        Map<Long,Long> dp = new HashMap<>();
        long result = cal(n,p,q,dp);

        System.out.println(result);
    }

    private static long cal(long n, long p, long q, Map<Long,Long> dp) {
        if(n == 0){
            return 1;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        dp.put(n,cal(n/p,p,q,dp) + cal(n/q,p,q,dp));
        return dp.get(n);
    }
}
