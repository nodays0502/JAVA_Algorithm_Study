package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_4811 {
    private static final int FINISH = 0;
    private static final int SIZE = 30;
    private static final int NOT_VALID = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        long[][] dp = new long[2*SIZE+1][SIZE+1];
        for(int i = 0 ; i <= 2*SIZE ; i++){
            Arrays.fill(dp[i],NOT_VALID);
        }
        while(true){
            int num = stoi.apply(br.readLine());
            if(num == FINISH){
                break;
            }
            long result = cal(2*num, num, dp, num);
            System.out.println(result);
        }
    }

    private static long cal(int depth,int cnt,long[][] dp,int n) {
        if(depth == 0){
            return 1;
        }
        if( dp[depth][cnt] != NOT_VALID){
            return dp[depth][cnt];
        }
        long result = 0;
        if(depth > 2 * cnt || cnt == 0){
            result += cal(depth-1,cnt,dp,n);
        }
        if(cnt > 0){
            result += cal(depth-1,cnt-1,dp,n); // 반으로 쪼개기
        }
        dp[depth][cnt] = result;
        return result;
    }
}
