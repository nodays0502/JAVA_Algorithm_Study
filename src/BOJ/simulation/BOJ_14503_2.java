package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_2 {
        private static final int[] DY = {-1,0,1,0};
        private static final int[] DX = {0,1,0,-1};
        private static final int BLOCK = 1;
        private static final int EMPTY = 0;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            for(int i = 0 ; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ;j < m ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = cal(startY,startX,dir,map,n,m);
            System.out.println(result);
        }

        private static int cal(int startY, int startX, int dir, int[][] map, int n, int m) {
            int cnt = 0;
            boolean[][] isClean = new boolean[n][m];
            int y = startY;
            int x = startX;
            while(true){
                if(!isClean[y][x]){
                    isClean[y][x] = true;
                    cnt++;
                }
                if(haveNearNoClean(y,x,isClean,map,n,m)){ // 4칸 중 청소되지 않은 칸이 있다면
                    dir = (dir + 3) % 4; // 90도 회전
                    int ny = y + DY[dir];
                    int nx = x + DX[dir];
                    while(map[ny][nx] == BLOCK || isClean[ny][nx]){
                        dir = (dir + 3) % 4;
                        ny = y + DY[dir];
                        nx = x + DX[dir];
                    }
                    // 한칸 전진
                    y = ny;
                    x = nx;
                    continue;
                }

                int ny = y - DY[dir];
                int nx = x - DX[dir];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == BLOCK){ // 뒤가 벽이거나 밖으로 나가지게 된다면
                    break;
                }
                // 후진
                y = ny;
                x = nx;
            }
            return cnt;
        }

        private static boolean haveNearNoClean(int y, int x, boolean[][]isClean ,int[][] map, int n, int m) {
            for(int i = 0 ; i < 4 ; i++){
                int ny = y + DY[i];
                int nx = x + DX[i];
                if(ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != BLOCK && !isClean[ny][nx]){
                    return true;
                }
            }
            return false;
        }
    }