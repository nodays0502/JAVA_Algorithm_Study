package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11967 {
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());

        List<int[]> [][] map = new List[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                map[i][j] = new ArrayList<>();
            }
        }
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int y = stoi.apply(st.nextToken())-1;
            int x = stoi.apply(st.nextToken())-1;
            int a = stoi.apply(st.nextToken())-1;
            int b = stoi.apply(st.nextToken())-1;
            map[y][x].add(new int[] {a,b});
            set.add(Arrays.toString(new int[]{a,b}));
        }
        Queue<int[]> q = new LinkedList<>();
        int result = 1;
        boolean[][] isVisited = new boolean[n][n];
        boolean[][] isSwitched = new boolean[n][n];
        isSwitched[0][0] = true;
        q.offer(new int[] {0,0});
        while(!q.isEmpty()){
            int size = q.size();
            boolean isChange = false;
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                int y = now[0];
                int x = now[1];
                if(!isSwitched[y][x]){
                    q.offer(new int[] {y,x});
                    continue;
                }
                isChange = true;
                for(int i = 0 ; i < map[y][x].size(); i++){
                    int[] next = map[y][x].get(i);
                    int nextY = next[0];
                    int nextX = next[1];
                    if(!isSwitched[nextY][nextX]){
                        result++;
                        isSwitched[nextY][nextX] = true;
                    }
                }
                for(int i = 0; i < 4; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && !isVisited[ny][nx]){
                        if(isSwitched[ny][nx] || set.contains(Arrays.toString(new int[]{ny,nx}))){
                            isVisited[ny][nx] = true;
                            q.offer(new int[] {ny,nx});
                        }
                    }
                }
            }
            if(!isChange){
                break;
            }
        }
        System.out.println(result);
    }
}
