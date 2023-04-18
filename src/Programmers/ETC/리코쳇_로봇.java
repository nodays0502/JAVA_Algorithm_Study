package Programmers.ETC;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇_로봇 {
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static final int NOT_FOUND = -1;
    public int solution(String[] board) {
        char[][] map = makeMap(board);
        int answer = bfs(map);
        return answer;
    }
    private static final char START = 'R';
    private static final char EMPTY = '.';
    private static final char END = 'G';
    private static int bfs(char[][] map){
        int n = map.length;
        int m = map[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == START){
                    q.offer(new int[]{i,j});
                    // visited[i][j] = true;
                    map[i][j] = EMPTY;
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                // System.out.println(time+" "+Arrays.toString(now));
                if(map[now[0]][now[1]] == END){
                    return time;
                }
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    while(nx >= 0 && nx < m && ny >= 0 && ny < n &&
                        (map[ny][nx] == EMPTY || map[ny][nx] == END) ) {
                        ny += DY[i];
                        nx += DX[i];
                    }
                    ny -= DY[i];
                    nx -= DX[i];
                    if(!visited[ny][nx]){
                        q.offer(new int[]{ny,nx});
                        visited[ny][nx] = true;
                    }
                }
            }
            time++;
        }
        return NOT_FOUND;
    }
    private static char[][] makeMap(String[] board){
        int n = board.length;
        int m = board[0].length();
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        return map;
    }
}
