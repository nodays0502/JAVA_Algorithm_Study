package BOJ.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_10994 {
    private static int[] dy = {0,1,0,-1};
    private static int[] dx = {1,0,-1,0};
    private static void paint(int depth, char[][]map, int totalLength){
        int y = 2 * depth;
        int x = 2 * depth;
        for(int i = 0 ; i < 4; i++){
            while(y >= 2 * depth && y < totalLength - 2 * depth
                && x >= 2 * depth && x < totalLength - 2 * depth){
                map[y][x] = '*';
                y += dy[i];
                x += dx[i];
            }
            y -= dy[i];
            x -= dx[i];
        }
        if(depth < totalLength / 2 + 1){
            paint(depth + 1,map,totalLength);
        }
    }
    private static void print(char[][] map, int length){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < length ; i++){
            for(int j = 0 ; j < length; j++){
                if(map[i][j] == '*'){
                    sb.append('*');
                }else{
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int length = 4 * (n - 1) + 1;
        char[][] map = new char[length][length];
        paint(0,map,length);
        print(map,length);
    }
}
