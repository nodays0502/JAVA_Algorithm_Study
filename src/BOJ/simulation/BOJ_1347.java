package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_1347 {
    private static final int SIZE = 50;
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char EMPTY = '.';
    private static final char BLOCK = '#';
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        String command = br.readLine();
        cal(command,n);
    }

    private static void cal(String command, int n) {
        boolean[][] visited = new boolean[2*SIZE + 1][2*SIZE + 1];
        int dir = 2;
        int y = SIZE;
        int x = SIZE;
        visited[y][x] = true;
        int maxY = SIZE;
        int minY = SIZE;
        int maxX = SIZE;
        int minX = SIZE;
        for(int i = 0 ; i < n ; i++){
            char ch = command.charAt(i);
            if(ch == LEFT){
                dir = (dir+3) % 4;
            }else if(ch == RIGHT){
                dir = (dir+1) % 4;
            }else{
                y += DY[dir];
                x += DX[dir];
                visited[y][x] = true;
                maxY = Math.max(maxY,y);
                minY = Math.min(minY,y);
                maxX = Math.max(maxX,x);
                minX = Math.min(minX,x);
            }
        }
        for(int i = minY ; i <= maxY ; i++){
            for(int j = minX ; j <= maxX ; j++){
                if(visited[i][j]){
                    System.out.print(EMPTY);
                }else{
                    System.out.print(BLOCK);
                }
            }
            System.out.println();
        }
    }
}
