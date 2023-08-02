package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1051 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(command.charAt(j)+"");
            }
        }
        int result = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int length = 0;
                while(true){
                    if(i + length >= n || j + length >= m){
                        break;
                    }
                    if(map[i][j] == map[i+length][j] && map[i][j] == map[i][j+length] && map[i][j] == map[i+length][j+length]){
                        result = Math.max(result,(length + 1)*(length+1) );
                    }
                    length++;
                }
            }
        }
        System.out.println(result);
    }
}
