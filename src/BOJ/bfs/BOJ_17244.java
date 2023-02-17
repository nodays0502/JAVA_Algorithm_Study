package BOJ.bfs;

import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17244 {
    private static final int BLOCK = -1;
    private static final int EMPTY = 0;
    private static final int END = -3;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int m = stoi.apply(st.nextToken());
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        int number = 1;
        int startY = 0;
        int startX = 0;
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                char ch = command.charAt(j);
                if(ch == '#'){
                    map[i][j] = BLOCK;
                }else if(ch == 'S'){
                    startY = i;
                    startX = j;
                    map[i][j] = EMPTY;
                }else if(ch == '.'){
                    map[i][j] = EMPTY;
                }else if(ch == 'X'){
                    map[i][j] = number++;
                }else if(ch == 'E'){
                    map[i][j] = END;
                }
            }
        }
        int result = cal(startY,startX,map,n,m,number-1);
        System.out.println(result);
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int cal(int startY, int startX, int[][] map, int n, int m,int num) {

        int ALL_FOUND = (int)Math.pow(2,num) - 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {startY,startX,0});
        int itemCount = (int)(Math.pow(2,num));
        boolean[][][] visited = new boolean[n][m][itemCount];
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(map[now[0]][now[1]] == END && now[2] == ALL_FOUND){
                    return time;
                }
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == BLOCK){
                        continue;
                    }
                    int nowItemCnt = now[2];
                    if(map[ny][nx] > 0){
                        nowItemCnt = now[2] | findItem(map[ny][nx]);
                    }
                    if(!visited[ny][nx][nowItemCnt]){
                        visited[ny][nx][nowItemCnt] = true;
                        q.offer(new int[]{ny,nx,nowItemCnt});
                    }
                }
            }
            time++;
        }
        return -1;
    }

    private static int findItem(int num) {
        return (int)(Math.pow(2,num-1));
    }
}
