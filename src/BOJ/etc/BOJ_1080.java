package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1080 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi =Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][][] arr = new int[2][n][m];
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < n ; j++){
                String command = br.readLine();
                for(int k = 0 ; k < m ; k++){
                    arr[i][j][k] = stoi.apply(command.charAt(k)+"");
                }
            }
        }
        int result = cal(0,0,arr,n,m);
        if(result == INF){
            System.out.println(NOT_FOUND);
        }else{
            System.out.println(result);
        }
    }
    private static final int SIZE = 3;
    private static final int NOT_FOUND = -1;
    private static final int INF = 987654321;
    private static int cal(int y, int x, int[][][] arr, int n, int m) {
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(arr[0][i][j] != arr[1][i][j]){
                    if(i + SIZE > n || j + SIZE > m){
                        return NOT_FOUND;
                    }
                    change(i,j,arr);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void change(int y, int x, int[][][] arr) {
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                arr[0][y+i][x+j] = (arr[0][y+i][x+j] + 1) % 2;
            }
        }
    }

    private static boolean isSame(int[][][] arr, int n, int m) {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(arr[0][i][j] != arr[1][i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
