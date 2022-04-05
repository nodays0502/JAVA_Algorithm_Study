package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_20058 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int q = stoi.apply(st.nextToken());
        int size = (int)(Math.pow(2,n));
        int[][] map = new int[size][size];
        for(int i = 0 ; i < size ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < size ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < q ; i++){
            int num = stoi.apply(st.nextToken());
            rotationAll(map,num,size);
            checkIce(map,size);
        }
        System.out.println(checkIceCnt(map,size));
        System.out.println(checkIceArea(map,size));
    }

    private static int checkIceArea(int[][] map, int size) {
        int result = 0;
        boolean[][] visited = new boolean[size][size];
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size; j++){
                if(map[i][j] > 0 && !visited[i][j]){
                    result = Math.max(result,bfs(i,j,map,size,visited));
                }
            }
        }
        return result;
    }

    private static int bfs(int y, int x, int[][] map, int size,boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        visited[y][x] = true;
        int result = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            result++;
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(nx >= 0 && nx < size && ny >= 0 && ny < size && map[ny][nx] > 0 && !visited[ny][nx]){
                    q.offer(new int[] {ny,nx});
                    visited[ny][nx] = true;
                }
            }
        }
        return result;
    }

    private static int checkIceCnt(int[][] map, int size) {
        int result = 0;
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                result += map[i][j];
            }
        }
        return result;
    }

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    private static void checkIce(int[][] map, int size) {
        boolean[][] decreaseIce = new boolean[size][size];
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                int cnt = 0;
                for(int k = 0 ; k < 4 ; k++){
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if(nx >= 0 && nx < size && ny >= 0 && ny < size && map[ny][nx] > 0){
                        cnt++;
                    }
                }
                if(cnt < 3){
                    decreaseIce[i][j] = true;
                }
            }
        }
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(decreaseIce[i][j] && map[i][j] > 0){
                    map[i][j]--;
                }
            }
        }
    }

    private static void rotationAll(int[][] map, int num, int size) {
        int nowSize = (int)(Math.pow(2,num));
        for(int i = 0 ; i < size ; i += nowSize){
            for(int j = 0 ; j < size ; j += nowSize){
                rotation(i,j,map,nowSize);
            }
        }
    }

    private static void rotation(int y, int x, int[][] map, int nowSize) {
        int[][] temp = new int[nowSize][nowSize];
        for(int i = 0 ; i < nowSize ; i++){
            for(int j = 0 ; j < nowSize ; j++){
                temp[j][nowSize - 1 - i] = map[y+i][x+j];
            }
        }
        for(int i = 0 ; i < nowSize ; i++){
            for(int j = 0 ; j < nowSize ; j++){
                map[y+i][x+j] = temp[i][j];
            }
        }
//        for(int i = 0 ; i < nowSize ; i++){
//            for(int j = 0 ; j < nowSize ; j++){
//                System.out.print(temp[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
    }
}
