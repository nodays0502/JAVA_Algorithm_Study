package Programmers.ETC;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 리틀_프렌즈_사천성 {
    private static final int SIZE = 26;
    public String solution(int m, int n, String[] board) {
        String answer = "";
        boolean[] noVisited = new boolean[SIZE];
        List<int[]>[] map = init(m,n,board,noVisited);
        // for(List<int[]> i : map){
        //     System.out.println(i);
        // }
        char[][] charBoard = new char[m][n];
        for(int i = 0 ; i < m ; i++){
            charBoard[i] = board[i].toCharArray();
        }
        answer = match(map,charBoard,m,n,noVisited);
        return answer;
    }
    private static String match(List<int[]>[] map,char[][] board,int m,int n,boolean[] noVisited){
        StringBuilder sb = new StringBuilder();
        while(true){
            if(check(noVisited)){
                return sb.toString();
            }
            boolean flag = false;
            for(int i = 0 ; i < SIZE ; i++){
                if(noVisited[i]){
                    // System.out.println(i);
                    int sy = map[i].get(0)[0];
                    int sx = map[i].get(0)[1];
                    int ey = map[i].get(1)[0];
                    int ex = map[i].get(1)[1];
                    if(bfs(sy,sx,ey,ex,board,m,n)){
                        board[sy][sx] = '.';
                        board[ey][ex] = '.';
                        noVisited[i] = false;
                        sb.append((char)('A'+i));
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                break;
            }
        }

        return "IMPOSSIBLE";
    }



    private static boolean check(boolean []noVisited){
        for(int i = 0 ; i < SIZE ; i++){
            if(noVisited[i]){
                return false;
            }
        }
        return true;
    }
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    private static boolean bfs(int sy,int sx, int ey,int ex,char[][] board,int m, int n){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sy,sx});
        boolean[][] pathVisited = new boolean[m][n];
        pathVisited[sy][sx] = true;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                for(int i = 0 ; i < 4; i++){
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    while(checkBound(ny,nx,m,n) && (board[ny][nx] == '.' || board[ny][nx] == board[sy][sx])){
                        if(ny == ey && nx == ex){
                            return true;
                        }
                        if(!pathVisited[ny][nx]){
                            pathVisited[ny][nx] = true;
                            q.offer(new int[] {ny,nx});
                        }
                        ny += dy[i];
                        nx += dx[i];
                    }
                }
            }
            time++;
            if(time == 2){
                break;
            }
        }
        return false;
    }
    private static boolean checkBound(int y ,int x , int m , int n){
        if(y >= 0 && y < m && x >= 0 && x < n){
            return true;
        }
        return false;
    }
    private static List<int[]>[] init(int m, int n, String[] board,boolean[] noVisited){
        List<int[]>[] map = new ArrayList[SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            map[i] =  new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                char now = board[i].charAt(j);
                if(now == '*' || now == '.'){
                    continue;
                }
                noVisited[now-'A'] = true;
                map[now-'A'].add(new int[] {i,j});
            }
        }
        return map;
    }
}
