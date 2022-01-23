package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;
import org.w3c.dom.Node;

public class BOJ_16948 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int sy = stoi.apply(st.nextToken());
        int sx = stoi.apply(st.nextToken());
        int ey = stoi.apply(st.nextToken());
        int ex = stoi.apply(st.nextToken());
        System.out.println(bfs(sy,sx,ey,ex,n));
    }

    private static int bfs(int sy, int sx, int ey, int ex,int n) {
        int dy[] = {-2,-2,0,0,2,2};
        int dx[] = {-1,1,-2,2,-1,1};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sy,sx});
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
//                System.out.println(Arrays.toString(now));
                if(now[0] == ey && now[1] == ex){
                    return time;
                }
                for(int i = 0 ; i < 6 ; i++){
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
