package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14497 {

    private static final char EMPTY = '0';
    private static final char FRIEND = '1';
    private static final char TARGET = '#';
    private static final char START = '*';
    private static final int NOT_VALID = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int startY = Integer.parseInt(st.nextToken())-1;
        int startX = Integer.parseInt(st.nextToken())-1;
        int endY = Integer.parseInt(st.nextToken())-1;
        int endX = Integer.parseInt(st.nextToken())-1;
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = command.charAt(j);
            }
        }
        int result = bfs(startY, startX, endY, endX, map, n, m);
        System.out.println(result);
    }

    private static final int[] DY = {-1, 0, 1, 0};
    private static final int[] DX = {0, 1, 0, -1};

    private static int bfs(int startY, int startX, int endY, int endX, char[][] map, int n, int m) {
        PriorityQueue<int[]> q = new PriorityQueue<>((v1,v2)->{
            return v1[2] - v2[2];
        });
        q.offer(new int[]{startY, startX, 0});
        int[][] visited = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(visited[i],NOT_VALID);
        }
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + DY[i];
                int nx = now[1] + DX[i];
                int cnt = now[2];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (map[ny][nx] != EMPTY) {
                        cnt++;
                    }
                    if((visited[ny][nx] != 0 && visited[ny][nx] > cnt) || visited[ny][nx] == NOT_VALID){
                        visited[ny][nx] = cnt;
                        q.offer(new int[]{ny,nx,cnt});
                    }
                }
            }
        }
        return visited[endY][endX];
    }
}
