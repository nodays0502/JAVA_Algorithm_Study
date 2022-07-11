package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;


public class BOJ_1726 {
    static class Position{
        int y;
        int x;
        int dir;

        public Position(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
        public boolean isSame(Position position){
            if(this.y == position.y && this.x == position.x && this.dir == position.dir){
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startY = stoi.apply(st.nextToken())-1;
        int startX = stoi.apply(st.nextToken())-1;
        int startDir = changeDir(stoi.apply(st.nextToken()));
        Position start = new Position(startY,startX,startDir);

        st = new StringTokenizer(br.readLine());
        int endY = stoi.apply(st.nextToken())-1;
        int endX = stoi.apply(st.nextToken())-1;
        int endDir = changeDir(stoi.apply(st.nextToken()));
        Position end = new Position(endY,endX,endDir);

        int result = bfs(map,n,m,start,end);
        System.out.println(result);
    }
    private static final int EMPTY = 0;
    private static final int BLOCK = 1;
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int changeDir(int num){
        if(num == 1){ // 동쪽
            return 1;
        }
        if(num == 2){ // 서쪽
            return 3;
        }
        if(num == 3){ // 남쪽
            return 2;
        }
        if(num == 4){ // 북쪽
            return 0;
        }
        return -1;
    }
    private static int bfs(int[][] map, int n, int m, Position start, Position end) {
        Queue<Position> q = new LinkedList<>();
        int time = 0;
        boolean[][][] visited = new boolean[n][m][4];
        q.offer(start);
        while(!q.isEmpty()){
            int size = q.size();
//            System.out.println(time);
            for(int s = 0 ; s < size ; s++){
                Position now = q.poll();
//                System.out.println(now.y+" "+now.x+" "+now.dir);
                if(end.isSame(now)){
                    return time;
                }
                for(int i = -1 ; i <= 1; i++){
                    if(i == 0){
                        continue;
                    }
                    int nextDir = (now.dir + 4 + i) % 4;
                    if(!visited[now.y][now.x][nextDir]){
                        visited[now.y][now.x][nextDir] = true;
                        q.offer(new Position(now.y,now.x,nextDir));
                    }
                }
                for(int i = 1 ; i <= 3; i++){
                    int ny = now.y + i * DY[now.dir];
                    int nx = now.x + i * DX[now.dir];
                    if(!checkBound(ny,nx,n,m) || map[ny][nx] == BLOCK){
                        break;
                    }
                    if(!visited[ny][nx][now.dir]){
                        visited[ny][nx][now.dir] = true;
                        q.offer(new Position(ny,nx,now.dir));
                    }
                }
            }
            time++;
        }
        return -1;
    }
    private static boolean checkBound(int y,int x,int n,int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }
}
