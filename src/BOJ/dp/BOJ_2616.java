package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2616 {

    private static final int NOT_VALID = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        int[][] dp = new int[n][3+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], NOT_VALID);
            input[i] = stoi.apply(st.nextToken());
        }
        int interval = stoi.apply(br.readLine());
        int result = cal(0, 0, interval, input, n, dp);
        System.out.println(result);
    }

    private static int cal(int depth, int cnt, int interval, int[] input, int n, int[][] dp) {
        if (depth >= n) {
            return 0;
        }
        if (dp[depth][cnt] != NOT_VALID) {
            return dp[depth][cnt];
        }
        int result = 0;
        result = Math.max(result, cal(depth + 1, cnt, interval, input, n, dp));
        if (depth + interval <= n && cnt < 3) {
            int sum = 0;
            for (int i = 0; i < interval; i++) {
                sum += input[depth + i];
            }
            result = Math.max(result, cal(depth + interval, cnt + 1, interval, input, n, dp) + sum);
        }
        dp[depth][cnt] = result;
        return result;
    }
}
