package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_5546 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        Map<Integer,Integer> prevPasta = new HashMap<>();
        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine());
            int day = stoi.apply(st.nextToken());
            int type = stoi.apply(st.nextToken());
            prevPasta.put(day,type);
        }
        int[][][]dp = new int[n+1][3+1][3];
        for(int i = 0 ; i <= n ; i++){
            for(int j = 0 ; j <= 3; j++){
                Arrays.fill(dp[i][j],NOT_VALID);
            }
        }
        int result = cal(1,n,0,0,prevPasta,dp);
        System.out.println(result);
    }
    private static final int NOT_VALID = -1;
    private static final int LIMIT = 10_000;
    private static int cal(int depth, int n,int nowType,int cnt, Map<Integer, Integer> prevPasta,int[][][]dp) {
        if(depth > n){
            return 1;
        }

        int type = prevPasta.getOrDefault(depth,NOT_VALID);
        if(type != NOT_VALID){
            if(nowType == type){
                cnt++;
            }else{
                nowType = type;
                cnt = 1;
            }
            if(cnt >= 3){
                return 0;
            }
            return cal(depth+1,n,nowType,cnt,prevPasta,dp) % LIMIT;
        }
        if(dp[depth][nowType][cnt] != NOT_VALID){
            return dp[depth][nowType][cnt];
        }
        int result = 0;
        for(int i = 1 ; i <= 3; i++){
            if(nowType == i){
                if(cnt + 1 >= 3){
                    continue;
                }
                result += cal(depth+1,n,nowType,cnt+1,prevPasta,dp);
            }else{
                result += cal(depth+1,n,i,1,prevPasta,dp);
            }
        }
        dp[depth][nowType][cnt] = result;
        return result % LIMIT;
    }
}
