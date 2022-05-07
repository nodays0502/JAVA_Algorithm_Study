package Programmers.ETC;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    private static final int NO_ANSWER = -1;
    private static final int EMPTY = 1;
    private static final int WALL = 0;

    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private int bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int time = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                // System.out.println(time+" "+Arrays.toString(now));
                if(now[0] == n-1 && now[1] == m-1){
                    return time;
                }
                for(int dir = 0 ; dir < 4; dir++){
                    int ny = now[0] + dy[dir];
                    int nx = now[1] + dx[dir];
                    if(checkBound(ny,nx,n,m) && !visited[ny][nx] && maps[ny][nx] == EMPTY){
                        visited[ny][nx] = true;
                        q.offer(new int[] {ny,nx});
                    }
                }
            }
            time++;
        }
        return NO_ANSWER;
    }
    private boolean checkBound(int y ,int x, int n, int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
