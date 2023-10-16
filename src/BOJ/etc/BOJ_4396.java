package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4396 {
    private static final char OPEN = 'x';
    private static final char EMPTY = '.';
    private static final char MINE = '*';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            String commmand = br.readLine();
            for(int j = 0 ; j < n ; j++){
                map[i][j] = commmand.charAt(j);
            }
        }
        char[][] click = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            String commmand = br.readLine();
            for(int j = 0 ; j < n ; j++){
                click[i][j] = commmand.charAt(j);
            }
        }
        char[][] result = cal(map,click,n);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
    private static final int[] DY = {-1,0,1,0,-1,1,1,-1};
    private static final int[] DX = {0,1,0,-1,1,1,-1,-1};
    private static char[][] cal(char[][] map, char[][] click, int n) {
        char[][] result = new char[n][n];
        boolean openedMine = false;
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(result[i],EMPTY);
            for(int j = 0 ; j < n ; j++){
                if(click[i][j] == OPEN && map[i][j] == MINE){
                    openedMine = true;
                }
                if(click[i][j] == OPEN){
                    int cnt = 0;
                    for(int k = 0 ; k < 8 ; k++){
                        int ny = i + DY[k];
                        int nx = j + DX[k];
                        if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[ny][nx] == MINE){
                            cnt++;
                        }
                    }
                    result[i][j] = (char)(cnt + '0');
                }
            }
        }
        if(!openedMine){
            return result;
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] == MINE){
                    result[i][j] = MINE;
                }
            }
        }
        return result;
    }
}
