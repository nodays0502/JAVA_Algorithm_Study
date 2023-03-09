package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10711 {
    private static final char EMPTY = '.';
    private static final int[] DY = {-1,0,1,0,-1,1,1,-1};
    private static final int[] DX = {0,1,0,-1,1,1,-1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                char ch = command.charAt(j);
                if(ch == EMPTY){
                    map[i][j] = 0;
                    q.offer(new int[] {i,j});
                }else{
                    map[i][j] = ch - '0';
                }
            }
        }
        int time = 0;
        int[][] cnt = new int[n][m];
        boolean[][] used = new boolean[n][m];
        Queue<int[]> bomb = new LinkedList<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                for(int i = 0 ; i < 8 ; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(checkBound(ny,nx,n,m)){
                        cnt[ny][nx]++;
                        if(map[ny][nx] != 0 && !used[ny][nx] && cnt[ny][nx] >= map[ny][nx]){
                            used[ny][nx] = true;
                            bomb.offer(new int[]{ny,nx});
                        }
                    }
                }
            }
            if(bomb.isEmpty()){
                break;
            }
            while(!bomb.isEmpty()){
                int[] now = bomb.poll();
                map[now[0]][now[1]] = 0;
                q.offer(now);
            }
            time++;
        }
        System.out.println(time);
    }

    private static boolean checkBound(int y, int x, int n, int m) {
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
