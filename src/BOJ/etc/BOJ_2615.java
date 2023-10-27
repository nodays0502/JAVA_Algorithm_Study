package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2615 {
    private static final int SIZE = 19;
    private static final int BLACK = 1;
    private static final int WHITE = 2;
    private static final int EMPTY = 0;
    private static final int DRAW = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String,Integer> stoi = Integer::parseInt;
        int[][] map = new int[SIZE+1][SIZE+1];
        for(int i = 1 ; i <= SIZE ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= SIZE ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        cal(map);
    }
//    private static final int[] DY = {-1,0,1,0,-1,1,1,-1};
//    private static final int[] DX = {0,1,0,-1,1,1,-1,-1};
    private static final int[] DY = {-1,0,1,1};
    private static final int[] DX = {1,1,1,0};
    private static void cal(int[][] map) {
        for(int j = 1 ; j <= SIZE ; j++){
            for(int i = 1 ; i <= SIZE ; i++){
                if(map[i][j] == EMPTY){
                    continue;
                }
                for(int k = 0 ; k < 4 ; k++){
                    int result = check(i,j,k,map);
                    if(result != DRAW){
                        System.out.println(map[i][j]);
                        System.out.println(i+" "+j);
                        return ;
                    }
                }
            }
        }
        System.out.println(DRAW);
        return;
    }

    private static int check(int y, int x, int dir, int[][] map) {
        int color = map[y][x];
        int prevY = y - DY[dir];
        int prevX = x - DX[dir];
        if(prevY >= 1 && prevY <= SIZE && prevX >= 1 && prevX <= SIZE && map[prevY][prevX] == color){
            return DRAW;
        }
        int cnt = 0;
        int ny = y;
        int nx = x;
        while(ny >= 1 && ny <= SIZE && nx >= 1 && nx <= SIZE && map[ny][nx] == color){
            cnt++;
            ny += DY[dir];
            nx += DX[dir];
        }
        if(cnt == 5){
            return color;
        }
        return DRAW;
    }
}
