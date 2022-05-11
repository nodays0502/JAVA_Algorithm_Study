package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16197 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        char map[][] = new char[n+2][m+2];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i+1][j+1] = command.charAt(j);
            }
        }
        System.out.println(bfs(map,n,m));
    }

    private static int bfs(char[][] map, int n, int m) {

        int dy[] = {-1,0,1,0};
        int dx[] = {0,1,0,-1};
        boolean[][][][] visited = new boolean[n+2][m+2][n+2][m+2];
        Queue<int[]> q = new LinkedList<>();
        int[] start = new int[]{-1,-1,-1,-1};
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1; j <= m ; j++){
                if(map[i][j] == 'o'){
                    if(start[0] == -1){
                        start[0] = i;
                        start[1] = j;
                    }else{
                        start[2] = i;
                        start[3] = j;
                    }
                }
            }
        }
        q.offer(start);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if( isDrop(now[0],now[1],n,m) != isDrop(now[2],now[3],n,m)  ){
                    return time;
                }else if(isDrop(now[0],now[1],n,m) ||isDrop(now[2],now[3],n,m)){
                    continue;
                }
                for(int i = 0 ; i < 4 ; i++){
                    int ny1 = now[0] + dy[i];
                    int nx1 = now[1] + dx[i];
                    int ny2 = now[2] + dy[i];
                    int nx2 = now[3] + dx[i];
                    if(isBound(ny1,nx1,n,m) && isBound(ny2,nx2,n,m)){
                        if(map[ny1][nx1] == '#'){
                            ny1 -= dy[i];
                            nx1 -= dx[i];
                        }
                        if(map[ny2][nx2] == '#'){
                            ny2 -= dy[i];
                            nx2 -= dx[i];
                        }
                        if(!visited[ny1][nx1][ny2][nx2]){
                            visited[ny1][nx1][ny2][nx2] = true;
                            q.offer(new int[] {ny1,nx1,ny2,nx2});
                        }
                    }
                }
            }
            time++;
            if(time > 10){
                break;
            }
        }
        return -1;
    }

    private static boolean isDrop(int y , int x , int n , int m){
        if((y == 0 || y == n+1 || x == 0 || x == m+1)){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isBound(int y, int x , int n, int m){
        if(y >= 0 && y <= n+1 && x >= 0 && x <= m+1){
            return true;
        }else{
            return false;
        }
    }
}
