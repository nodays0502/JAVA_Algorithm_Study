package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17136 {
    private static final int SIZE = 10;
    private static final int INF = 5*5 + 1;
    private static final int[] paper = {1,2,3,4,5};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String,Integer> stoi = Integer::parseInt;
        int[] cnt = {5,5,5,5,5};
        int[][] map = new int[SIZE][SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < SIZE ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = cal(0,0,map,cnt);
        if(result == INF){
            result = -1;
        }
        System.out.println(result);
    }

    private static int cal(int y, int x, int[][] map, int[] cnt) {
        if(y == SIZE){
            return 0;
        }
        int ny = y;
        int nx = x+1;
        if(nx >= SIZE){
            nx = 0;
            ny++;
        }
        int result = INF;
        if(map[y][x] == 1){
            for(int k = 4 ; k >= 0 ; k--){
                if(cnt[k] == 0){
                    continue;
                }
                if(!canFill(y,x,paper[k],map)){
                    continue;
                }
                fillMap(y,x,paper[k],map,0);
                cnt[k]--;
                result = Math.min(cal(ny, nx, map, cnt) + 1,result);
                fillMap(y,x,paper[k],map,1);
                cnt[k]++;
            }
        }else{
            result = Math.min(cal(ny, nx, map, cnt) ,result);
        }
        return result;
    }

    private static void fillMap(int y, int x, int length, int[][] map,int num) {
        for(int i = y ; i < y + length ; i++){
            for(int j = x ; j < x + length ; j++){
                map[i][j] = num;
            }
        }
    }

    private static boolean canFill(int y, int x, int length, int[][] map) {
        if(y+length > SIZE || x+length > SIZE){
            return false;
        }
        for(int i = y ; i < y + length ; i++){
            for(int j = x ; j < x + length ; j++){
                if(map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
