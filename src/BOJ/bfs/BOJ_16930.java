package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16930 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int startY = stoi.apply(st.nextToken()) - 1;
        int startX = stoi.apply(st.nextToken()) - 1;
        int endY = stoi.apply(st.nextToken()) - 1;
        int endX = stoi.apply(st.nextToken()) - 1;
        System.out.println(bfs(map,n,m,k,startY,startX,endY,endX));
    }
    private static class Node implements Comparable<Node> {
        int y;
        int x;
        int cnt;

        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }
    private static int bfs(char[][] map, int n ,int m , int k, int startY, int startX, int endY, int endX) {
        final int dy[] = {-1,0,1,0};
        final int dx[] = {0,1,0,-1};
        final int INF = 987654321;
        Queue<Node> q = new PriorityQueue<>();
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],INF);
        }
        q.offer(new Node(startY,startX,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.y == endY && now.x == endX){
                return now.cnt;
            }
            for(int i = 0 ; i < 4; i++){
                int ny = now.y;
                int nx = now.x;
                for(int j = 1 ; j <= k ; j++){
                    ny += dy[i];
                    nx += dx[i];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < m){
                        if(map[ny][nx] == '#' || dp[ny][nx] < now.cnt +1){
                            break;
                        }
                        if(dp[ny][nx] == INF){
                            dp[ny][nx] = now.cnt + 1;
                            q.offer(new Node(ny,nx,now.cnt + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
