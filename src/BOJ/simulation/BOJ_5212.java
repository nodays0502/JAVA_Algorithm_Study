package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_5212 {
    private static final char EARTH = 'X';
    private static final char SEA = '.';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = str.charAt(j);
            }
        }
        cal(map,n,m);
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static void cal(char[][] map, int n, int m) {
        boolean[][] check = new boolean[n][m];
        int minY = n;
        int minX = m;
        int maxY = 0;
        int maxX = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == SEA){
                    continue;
                }
                int cnt = 0;
                for(int k = 0 ; k < 4; k++){
                    int ny = i + DY[k];
                    int nx = j + DX[k];
                    if(nx < 0 || nx >= m || ny < 0 || ny >= n){
                        cnt++;
                        continue;
                    }
                    if(map[ny][nx] == SEA){
                        cnt++;
                    }
                }
                if(cnt >= 3){
                    check[i][j] = true;
                }else{
                    minY = Math.min(minY,i);
                    maxY = Math.max(maxY,i);
                    minX = Math.min(minX,j);
                    maxX = Math.max(maxX,j);
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(check[i][j]){
                    map[i][j] = SEA;
                }
            }
        }
        for(int i = minY ; i <= maxY ; i++){
            for(int j = minX ; j <= maxX ; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
