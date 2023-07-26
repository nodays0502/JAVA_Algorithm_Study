package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_10472 {

    private static final char BLACK = '*';
    private static final char WHITE = '.';
    private static final int[] DY = {0,-1,0,1,0};
    private static final int[] DX = {0,0,1,0,-1};
    private static final int SIZE = 3;
    private static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int testCnt = stoi.apply(br.readLine());
        for(int t = 0 ; t < testCnt ; t++){
            char[][] map = new char[SIZE][SIZE];
            for(int i = 0 ; i < SIZE ; i++){
                String command = br.readLine();
                for(int j = 0 ; j < SIZE ; j++){
                    map[i][j] = command.charAt(j);
                }
            }
            int result = cal(0,0,map);
            System.out.println(result);
        }
    }

    private static int cal(int y, int x, char[][] map) {
        int result = INF;
        if(y == SIZE){
            for(int i = 0 ; i < SIZE ; i++){
                for(int j = 0 ; j < SIZE ; j++){
                    if(map[i][j] == BLACK){
                        return INF;
                    }
                }
            }
            return 0;
        }
        int nextY = y;
        int nextX = x + 1;
        if(nextX >= SIZE){
            nextY = y+1;
            nextX = 0;
        }

        result = Math.min(result, cal(nextY,nextX,map));

        for(int k = 0 ; k < 5; k++){
            int ny = y + DY[k];
            int nx = x + DX[k];
            if(ny >= 0 && ny < SIZE && nx >= 0 && nx < SIZE){
                if(map[ny][nx] == BLACK){
                    map[ny][nx] = WHITE;
                }else{
                    map[ny][nx] = BLACK;
                }
            }
        }
        result = Math.min(result,cal(nextY,nextX,map) + 1);
        for(int k = 0 ; k < 5; k++){
            int ny = y + DY[k];
            int nx = x + DX[k];
            if(ny >= 0 && ny < SIZE && nx >= 0 && nx < SIZE){
                if(map[ny][nx] == BLACK){
                    map[ny][nx] = WHITE;
                }else{
                    map[ny][nx] = BLACK;
                }
            }
        }
        return result;
    }
}
