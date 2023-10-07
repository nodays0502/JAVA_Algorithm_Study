package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_14607 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        Map<Long,Long> dp = new HashMap<>();
        long result = cal(n, dp);
        System.out.println(result);
    }

    private static long cal(long depth, Map<Long,Long> dp) {
        if (depth == 1) {
            return 0;
        }
        if (dp.containsKey(depth)) {
            return dp.get(depth);
        }
        int temp = 0;
        if (depth % 2 != 0) {
            temp = 1;
        }
        long result = cal(depth / 2, dp) + cal(depth / 2 + temp, dp);
        result += (depth / 2) * (depth / 2 + temp);
        dp.put(depth,result);
        return result;
    }
}
