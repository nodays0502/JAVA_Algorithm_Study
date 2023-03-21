package Programmers.ETC;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 무인도_여행 {
    public int[] solution(String[] maps) {
        int[] answer = {};
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        List<Integer> result = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(maps[i].charAt(j) != BLOCK && !visited[i][j]){
                    int cnt = cal(i,j,visited,n,m,maps);
                    result.add(cnt);
                }
            }
        }
        Collections.sort(result);
        if(result.size() == 0){
            answer = new int[]{-1};
        }else{
            answer = new int[result.size()];
            for(int i = 0 ; i < result.size() ; i++){
                answer[i] = result.get(i);
            }
        }
        return answer;
    }
    private static final char BLOCK = 'X';
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int cal(int y,int x,boolean[][] visited,int n,int m,String[] map){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        int cnt = map[y].charAt(x) - '0';
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(ny >= 0 && nx >= 0 && nx < m && ny < n && !visited[ny][nx]
                    && map[ny].charAt(nx) != BLOCK){
                    q.offer(new int[] {ny,nx});
                    visited[ny][nx] = true;
                    cnt += map[ny].charAt(nx) - '0';
                }
            }
        }
        return cnt;
    }
}
