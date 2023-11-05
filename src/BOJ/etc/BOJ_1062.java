package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1062 {
    private static final int ALPHA_SIZE = 26;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] usedAlpha = new boolean[n][ALPHA_SIZE];
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < str.length() ; j++){
                char ch = str.charAt(j);
                usedAlpha[i][ch-'a'] = true;
            }
        }
        if(m < 5){
            System.out.println(0);
            return ;
        }

        boolean[] choice = new boolean[ALPHA_SIZE];
        choice['a' - 'a'] = true;
        choice['n' - 'a'] = true;
        choice['t' - 'a'] = true;
        choice['i' - 'a'] = true;
        choice['c' - 'a'] = true;
        int result = cal(0,0,choice,usedAlpha,n,m-5);
        System.out.println(result);
    }

    private static int cal(int depth, int start,boolean[] choice,boolean[][] usedAlpha, int n, int m) {
        if(depth == m){
            return findStr(choice,usedAlpha,n);
        }
        int result = 0;
        for(int i = start ; i < ALPHA_SIZE ; i++){
            if(choice[i]){
                continue;
            }
            choice[i] = true;
            result = Math.max(result,cal(depth+1,i+1,choice,usedAlpha,n,m));
            choice[i] = false;

        }
        return result;
    }

    private static int findStr(boolean[] choice, boolean[][] usedAlpha, int n) {

        int result = 0;
        for(int i = 0 ; i < n ; i++){
            boolean flag = true;
            for(int j = 0 ; j < ALPHA_SIZE ; j++){
                if(usedAlpha[i][j] && !choice[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result++;
            }
        }
        return result;
    }
}
