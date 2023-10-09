package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_29703 {

    private static final int NOT_FOUND = -1;
    private static final char START = 'S';
    private static final char HOUSE = 'H';
    private static final char EMPTY = 'E';
    private static final char DANGER = 'D';
    private static final char FISH = 'F';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        int startY = 0;
        int startX = 0;
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j]= command.charAt(j);
                if(map[i][j] == START){
                    startY = i;
                    startX = j;
                }
            }
        }
        int result = bfs(startY,startX,map,n,m);
        System.out.println(result);
    }

    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};

    private static int bfs(int startY, int startX, char[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startY,startX,0});
        int time = 0;
        boolean[][][] visited = new boolean[n][m][2];
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int s = 0 ; s < qSize ; s++){
                int[] now = q.poll();
                if(map[now[0]][now[1]] == HOUSE && now[2] == 1){
                    return time;
                }
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    int foundFish = now[2];
                    if(ny >= 0 && ny <n && nx >= 0 && nx < m && map[ny][nx] != DANGER && !visited[ny][nx][foundFish]){
                        if(map[ny][nx] == FISH){
                            foundFish = 1;
                        }
                        q.offer(new int[]{ny,nx,foundFish});
                        visited[ny][nx][foundFish] = true;
                    }
                }
            }
            time++;
        }
        return NOT_FOUND;
    }
}
