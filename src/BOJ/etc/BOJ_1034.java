package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1034 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j) - '0';
            }
        }
        int k = stoi.apply(br.readLine());
        boolean[] onSwitch = new boolean[m];
        int result = cal(0,onSwitch,n,m,k%m,map);
        System.out.println(result);
    }
    private static final int ON = 1;
    private static final int OFF = 0;
    private static int cal(int depth, boolean[] onSwitch, int n, int m,int cnt ,int[][] map) {
        if(depth == m && cnt == 0){
            int result = 0;
            changeMap(onSwitch,n,m,map);
            for(int i = 0 ; i < n ; i++){
                boolean flag = true;
                for(int j = 0 ; j < m ; j++){
                    if(map[i][j] == OFF){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    result++;
                }
            }
            changeMap(onSwitch,n,m,map);
            return result;
        }
        if(depth == m){
            return 0;
        }
        int result = 0;
        if(cnt > 0){
            onSwitch[depth] = true;
            result = Math.max(result, cal(depth+1,onSwitch,n,m,cnt-1,map));
            onSwitch[depth] = false;
        }
        result = Math.max(result, cal(depth+1,onSwitch,n,m,cnt,map));
        return result;
    }

    private static void changeMap(boolean[] onSwitch, int n, int m, int[][] map) {
        for(int i = 0 ; i < m ; i++){
            if(!onSwitch[i]){
                continue;
            }
            for(int j = 0 ; j < n ; j++){
                map[j][i] = (map[j][i] + 1) % 2;
            }
        }
    }
}
