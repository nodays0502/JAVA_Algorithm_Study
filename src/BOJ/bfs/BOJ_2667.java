package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < n ; j++){
                map[i][j] = command.charAt(j)-'0';
            }
        }

        boolean[][] visited = new boolean[n][n];
        List<Integer> list = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j] && map[i][j] != EMPTY){
                    list.add(cal(i,j,map,visited,n));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int num : list){
            System.out.println(num);
        }
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static final int EMPTY = 0;
    private static int cal(int y, int x, int[][] map, boolean[][] visited,int n) {
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        int cnt = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            cnt++;
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx] || map[ny][nx] == EMPTY){
                    continue;
                }
                visited[ny][nx] = true;
                q.offer(new int[]{ny,nx});
            }
        }
        return cnt;
    }
}
