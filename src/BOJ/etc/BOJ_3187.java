package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187 {
    private static final char EMPTY = '.';
    private static final char BLOCK = '#';
    private static final char SHEEP = 'k';
    private static final char WOLF = 'v';
    private static final int WOLF_INDEX = 0;
    private static final int SHEEP_INDEX = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = str.charAt(j);
            }
        }
        boolean[][] visited = new boolean[n][m];
        int[] cnt = new int[2];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && (map[i][j] == WOLF || map[i][j] == SHEEP) ){
                    int[] temp = bfs(i,j,map,visited,n,m);
                    cnt[WOLF_INDEX] += temp[WOLF_INDEX];
                    cnt[SHEEP_INDEX] += temp[SHEEP_INDEX];
                }
            }
        }
        System.out.println(cnt[SHEEP_INDEX] +" "+cnt[WOLF_INDEX]);
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int[] bfs(int y, int x,char[][]map, boolean[][] visited,int n,int m) {
        int[] cnt = new int[2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(map[now[0]][now[1]] == WOLF){
                cnt[WOLF_INDEX]++;
            }
            if(map[now[0]][now[1]] == SHEEP){
                cnt[SHEEP_INDEX]++;
            }
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && map[ny][nx] != BLOCK){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        if(cnt[WOLF_INDEX] >= cnt[SHEEP_INDEX]){
            cnt[SHEEP_INDEX] = 0;
        }else{
            cnt[WOLF_INDEX] = 0;
        }
        return cnt;
    }
}
