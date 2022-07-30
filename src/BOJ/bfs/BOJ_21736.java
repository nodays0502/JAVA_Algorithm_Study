package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21736 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        char[][] input = new char[n][m];
        int startY = 0;
        int startX = 0;
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                input[i][j] = command.charAt(j);
                if(input[i][j] == START){
                    startY = i;
                    startX = j;
                }
            }
        }
        int friendCnt = bfs(startY,startX,input,n,m);
        if(friendCnt == 0){
            System.out.println("TT");
        }else{
            System.out.println(friendCnt);
        }
    }

    private static final char START = 'I';
    private static final char FRIEND = 'P';
    private static final char WALL = 'X';
    private static final char EMPTY = 'O';

    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};

    private static int bfs(int startY,int startX, char[][] input, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startY,startX});

        boolean[][] visited = new boolean[n][m];
        visited[startY][startX] = true;
        int friendCnt = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(input[now[0]][now[1]] == FRIEND){
                friendCnt++;
            }
            for(int i = 0 ; i < 4; i++){
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                if(checkBound(ny,nx,n,m) && !visited[ny][nx] && input[ny][nx] != WALL){
                    visited[ny][nx] = true;
                    q.offer(new int[] {ny,nx});
                }
            }
        }
        return friendCnt;
    }
    private static boolean checkBound(int y,int x,int n,int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
