package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_9711 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        BigInteger[] dp = new BigInteger[10_000 + 1];
        Arrays.fill(dp, NOT_VALID);
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = stoi.apply(st.nextToken());
            int q = stoi.apply(st.nextToken());
            BigInteger result = cal(p, dp).mod(new BigInteger(Integer.toString(q)));
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static final BigInteger NOT_VALID = new BigInteger("-1");

    private static BigInteger cal(int p, BigInteger[] dp) {
        if (dp[p] != NOT_VALID) {
            return dp[p];
        }
        return dp[p] = cal(p - 1, dp).add(cal(p - 2, dp));
    }
}
