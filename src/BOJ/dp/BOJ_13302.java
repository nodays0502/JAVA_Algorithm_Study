package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13302 {
    private static final int[] MONEY = new int[] {10_000, 25_000, 37_000};
    private static final int[] DAY = new int[] {1, 3, 5};
    private static final int[] COUPON = new int[] {0, 1, 2};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        boolean[] noReservation = new boolean[n+1];
        if(m != 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < m ; i++){
                int day = stoi.apply(st.nextToken())-1;
                noReservation[day] = true;
            }

        }
        int[][] dp = new int[n+1][2*n+1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i],NOT_VALID);

        }
        int result = cal(0,0,noReservation,n,dp);
        System.out.println(result);
    }
    private static final int INF = 987654321;
    private static final int NOT_VALID = -1;
    private static int cal(int depth, int coupon, boolean[] noReservation, int n,int[][] dp) {
        if(depth >= n){
            return 0;
        }
        if(noReservation[depth]){
            return cal(depth+1,coupon,noReservation,n,dp);
        }
        if(dp[depth][coupon] != NOT_VALID){
            return dp[depth][coupon];
        }
        int result = INF;
        if(coupon >= 3){
            result = Math.min(result,cal(depth+1,coupon - 3,noReservation,n,dp));
        }
        for(int i = 0 ; i < 3; i++){
            result = Math.min(result,cal(depth+DAY[i],coupon+COUPON[i],noReservation,n,dp) + MONEY[i]);
        }
        dp[depth][coupon] = result;
        return result;
    }
}
