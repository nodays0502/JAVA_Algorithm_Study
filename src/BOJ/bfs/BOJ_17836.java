package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17836 {
    private static final String FAIL = "Fail";
    private static final int NOT_FOUND = -1;
    private static final int FOUND_SWARD = 1;
    private static final int NOT_FOUND_SWARD = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int limitTime = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = bfs(map,n,m,limitTime);
        if(result != NOT_FOUND){
            System.out.println(result);
            return;
        }
        System.out.println(FAIL);
    }

    private static final int EMPTY = 0;
    private static final int BLOCK = 1;
    private static final int SWARD = 2;
    private static class Node{
        int y;
        int x;
        int sward;

        public Node(int y, int x, int sward) {
            this.y = y;
            this.x = x;
            this.sward = sward;
        }
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int bfs(int[][] map, int n, int m, int limitTime) {
        Queue<Node> q = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];
        q.offer(new Node(0,0,NOT_FOUND_SWARD));
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                Node now = q.poll();
//                System.out.println(now.y+" "+now.x+" "+now.sward+" "+time);
                if(now.y == n-1 && now.x == m-1){
                    return time;
                }
                for(int dir = 0 ; dir < 4 ; dir++){
                    int ny = now.y + DY[dir];
                    int nx = now.x + DX[dir];
                    int sward = now.sward;
                    if( (checkBound(ny,nx,n,m) && !visited[ny][nx][sward] && map[ny][nx] != BLOCK) ||
                        (sward == FOUND_SWARD && checkBound(ny,nx,n,m) && !visited[ny][nx][sward]) ){
                        visited[ny][nx][sward] = true;
                        if(map[ny][nx] == SWARD){
                            sward = FOUND_SWARD;
                        }
                        q.offer(new Node(ny,nx,sward));
                    }
                }
            }
            time++;
            if(time > limitTime){
                break;
            }
        }
        return NOT_FOUND;
    }
    private static boolean checkBound(int y ,int x , int n, int m){
        if(y >= 0 && y < n && x >= 0 && x < m){
            return true;
        }
        return false;
    }

}
