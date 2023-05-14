package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18404 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = stoi.apply(st.nextToken())-1;
        int y = stoi.apply(st.nextToken())-1;
        int[][] map = bfs2(y,x,n);
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int endX = stoi.apply(st.nextToken())-1;
            int endY = stoi.apply(st.nextToken())-1;
            System.out.print(map[endY][endX]+" ");
        }
    }

    private static int[][] bfs2(int y, int x, int n) {
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(map[i],-1);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        map[y][x] = 0;
        int time = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                for(int i = 0 ; i < 8;  i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < n && map[ny][nx] == -1){
                        map[ny][nx] = time;
                        q.offer(new int[] {ny,nx});
                    }
                }
            }
            time++;
        }
        return map;
    }

    private static final int[] DY = {-1,-1,1,1,2,2,-2,-2};
    private static final int[] DX = {2,-2,2,-2,1,-1,1,-1};
    private static int bfs(int y, int x, int endY, int endX, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        int time = 0;
        Set<String> visited = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(now[0] == endY && now[1] == endX){
                    return time;
                }
                for(int i = 0 ; i < 8;  i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    int[] next = new int[]{ny,nx};
                    if(ny >= 0 && ny < n && nx >= 0 && nx < n && !visited.contains(Arrays.toString(next))){
                        visited.add(Arrays.toString(next));
                        q.offer(new int[] {ny,nx});
                    }
                }
            }
            time++;
        }
        return time;
    }
}
