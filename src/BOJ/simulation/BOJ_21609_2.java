package BOJ.simulation;



import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21609_2 {
    private static final int BLACK_BLOCK = -1;
    private static final int RAINBOW_BLOCK = 0;
    private static final int EMPTY = -99;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int cnt = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = 0;
        while(true){
            int temp = doPlay(map,n);
            result += temp;
            if(temp == 0){
                break;
            }
        }
        System.out.println(result);
    }
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static int doPlay(int[][] map, int n){
        int[] maxCnt = {0,0};
        int[] position = new int[]{0,0};
        boolean[][] visited = new boolean[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] == EMPTY || map[i][j] == BLACK_BLOCK || map[i][j] == RAINBOW_BLOCK || visited[i][j])  {
                    continue;
                }
                int[] cnt = bfs(i,j,map,n,visited);
                if(cnt[0] > maxCnt[0] || (cnt[0] == maxCnt[0] && cnt[1] > maxCnt[1]) ||
                    (cnt[0] == maxCnt[0] && cnt[1] == maxCnt[1] && position[0] < i) ||
                    (cnt[0] == maxCnt[0] && cnt[1] == maxCnt[1] && position[0] == i && position[1] < j)) {
                    maxCnt = cnt;
                    position = new int[] {i,j};
                }
            }
        }
        if(maxCnt[0] < 2){
            return 0;
        }
        delete(position[0],position[1],map,n);
        gravity(map,n);
        rotation(map,n);
        gravity(map,n);
        return maxCnt[0] * maxCnt[0];
    }
    private static void delete(int y, int x, int[][] map, int n) {
        Queue<int[]> q = new LinkedList<>();
        int color = map[y][x];
        q.offer(new int[] {y,x});
        map[y][x] = EMPTY;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(checkBound(ny,nx,n) && (map[ny][nx] == color || map[ny][nx] == RAINBOW_BLOCK) ){
                    map[ny][nx] = EMPTY;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
    }
    private static int[] bfs(int y, int x, int[][] map, int n,boolean[][] globalVisited) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        int color = map[y][x];
        visited[y][x] = true;
        globalVisited[y][x] = true;
        q.offer(new int[] {y,x});
        int cnt = 1;
        int rainbowCnt = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(checkBound(ny,nx,n) && !visited[ny][nx] && (map[ny][nx] == color || map[ny][nx] == RAINBOW_BLOCK) ){
                    cnt++;
                    if(map[ny][nx] == RAINBOW_BLOCK){
                        rainbowCnt++;
                    }else{
                        globalVisited[ny][nx] = true;
                    }
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        return new int[] {cnt,rainbowCnt};
    }

    private static boolean checkBound(int ny, int nx, int n) {
        if(ny >= 0 && ny < n && nx >= 0 && nx < n){
            return true;
        }
        return false;
    }

    private static void print(int[][] arr, int n) {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void rotation(int[][] arr, int n){
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                temp[n-1-j][i] = arr[i][j];
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = temp[i][j];
            }
        }
    }
    private static void gravity(int[][] arr ,int n){
        for(int row = 0 ; row < n ; row++){
            int emptyIndex = n-1;
            for(int col = n-1 ; col >= 0 ; col--){
                if(arr[col][row] == BLACK_BLOCK){
                    emptyIndex = col-1;
                    continue;
                }
                if(arr[col][row] != EMPTY){
                    int temp = arr[col][row];
                    arr[col][row] = arr[emptyIndex][row];
                    arr[emptyIndex][row] = temp;
                    emptyIndex--;
                }
            }
        }
    }
}
