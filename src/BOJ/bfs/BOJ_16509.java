package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16509 {
    private static final int[] DY = {-3,-2,2,3,3,2,-2,-3};
    private static final int[] DX = {2,3,3,2,-2,-3,-3,-2};
    private static final int[][] CHECK_Y = {
        {-1,-2,-3},
        {0,-1,-2},
        {0,1,2},
        {1,2,3},
        {1,2,3},
        {0,1,2},
        {0,-1,-2},
        {-1,-2,-3}
    };
    private static final int[][] CHECK_X = {
        {0,1,2},
        {1,2,3},
        {1,2,3},
        {0,1,2},
        {0,-1,-2},
        {-1,-2,-3},
        {-1,-2,-3},
        {0,-1,-2}
    };
    private static final int MAX_Y = 9;
    private static final int MAX_X = 8;
    private static final int NOT_FOUND = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int sangY = stoi.apply(st.nextToken());
        int sangX = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int kingY = stoi.apply(st.nextToken());
        int kingX = stoi.apply(st.nextToken());
        int result = bfs(sangY,sangX,kingY,kingX);
        System.out.println(result);
    }

    private static int bfs(int sangY, int sangX, int kingY, int kingX) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sangY,sangX});
        int time = 0;
        boolean[][] visited = new boolean[MAX_Y+1][MAX_X+1];
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int s = 0 ; s < qSize ; s++){
                int[] now = q.poll();
                if(now[0] == kingY && now[1] == kingX){
                    return time;
                }
                for(int i = 0 ; i < 8 ; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(ny >= 0 && ny <= MAX_Y && nx >= 0 && nx <= MAX_X && !visited[ny][nx]){
                        boolean flag = true;
                        for(int j = 0 ; j < 2; j++){
                            if(now[0] + CHECK_Y[i][j] == kingY && now[1] + CHECK_X[i][j] == kingX){
                                flag = false;
                                break;
                            }
                        }
                        if(flag){
                            q.offer(new int[]{ny,nx});
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
            time++;
        }
        return NOT_FOUND;
    }
}
