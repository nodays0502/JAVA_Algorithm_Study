package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15558 {
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    private static final int DANGER = 0;
    private static final int SAFE = 1;
    private static Function<String,Integer> stoi = Integer::parseInt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[][] line = new int[2][n];
        for(int i = 0 ; i < 2 ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < n ; j++){
                line[i][j] = command.charAt(j) - '0';
            }
        }
        int result = bfs(line,n,k);
        System.out.println(result);
    }
    private static int bfs(int[][] line, int n, int k){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        boolean[][] visited = new boolean[2][n];
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int t = 0 ; t < size ; t++){
                int[] now = q.poll();
                if(now[1] < time){
                    continue;
                }
//                System.out.println(time+" "+Arrays.toString(now));
                for(int i = -1 ; i <= 1; i++){
                    int ny = now[0];
                    int nx = now[1] + i;
                    if(i == 0){
                        ny = (now[0] + 1) % 2;
                        nx = now[1] + k;
                    }
                    if(nx >= n){
                        return SUCCESS;
                    }
                    if(nx < 0){
                        continue;
                    }
                    if(line[ny][nx] == DANGER){
                        continue;
                    }
                    if(!visited[ny][nx]){
                        q.offer(new int[] {ny,nx});
                        visited[ny][nx] = true;
                    }
                }
            }
            time++;
        }
        return FAIL;
    }
}
