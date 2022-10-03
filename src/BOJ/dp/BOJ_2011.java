package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2011 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        int size = command.length();
        char[] arr = command.toCharArray();
        int[] dp = new int[size];
        Arrays.fill(dp, NOT_VALID);
        int result = cal(0, size, arr, dp);
        System.out.println(result);
    }

    private static final int NOT_VALID = -1;
    private static final int LIMIT = 1000000;

    private static int cal(int depth, int size, char[] arr,int[] dp) {
        if(depth == size){
            return 1;
        }
        if(dp[depth] != NOT_VALID){
            return dp[depth];
        }
        int result = 0;
        if(depth+1 < size && arr[depth] != '0'){
            int num = (arr[depth] - '0') * 10 + (arr[depth+1] - '0');
            if(num >= 1 && num <= 26){
                result += cal(depth+2,size,arr,dp) % LIMIT;
                result %= LIMIT;
            }
        }
        if(arr[depth] != '0'){
            result += cal(depth+1,size,arr,dp) % LIMIT;
            result %= LIMIT;
        }
        dp[depth] = result;
        return result;
    }
}
