package BOJ.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9252 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[][] dp = new int[a.length()][b.length()];
        for(int i = 0 ; i < a.length() ; i++){
            for(int j = 0 ; j < b.length() ; j++){
                int isSame = 0;
                if(a.charAt(i) == b.charAt(j)){
                    isSame = 1;
                }
                int result = isSame;
                if(i != 0){
                    result = Math.max(result, dp[i-1][j]);
                }
                if(j != 0){
                    result = Math.max(result, dp[i][j-1]);
                }
                if(i != 0 && j != 0 ){
                    result = Math.max(result, dp[i-1][j-1] + isSame);
                }
                dp[i][j] = result;
            }
        }
        System.out.println(dp[a.length()-1][b.length()-1]);
        int y = a.length()-1;
        int x = b.length()-1;
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        while(y >= 0 &&  x >= 0){
            if(a.charAt(y) == b.charAt(x)){
                sb.append(a.charAt(y));
                y--;
                x--;
            }else if(y-1 < 0){
                x--;
            }else if(x-1 < 0){
                y--;
            }else if(dp[y-1][x] > dp[y][x-1]){
                y--;
            }else{
                x--;
            }
        }
        System.out.println(sb.reverse().toString());
    }
}
