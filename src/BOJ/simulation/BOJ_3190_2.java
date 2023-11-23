package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1290 {
    private static final char LEFT = 'L';
    private static final char RIGHT = 'D';
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int appleCnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[][] isApple = new boolean[n][n];
        for(int i = 0 ; i < appleCnt ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            isApple[a][b] = true;
        }
        int dirCnt = Integer.parseInt(br.readLine());
        int[] time = new int[dirCnt];
        char[] nextDir = new char[dirCnt];
        for(int i = 0 ; i < dirCnt ; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            nextDir[i] = st.nextToken().charAt(0);
        }
        int result = cal(isApple,n,time,nextDir,dirCnt);
        System.out.println(result);
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int cal(boolean[][] isApple, int n, int[] time, char[] nextDir, int dirCnt) {
        int y = 0;
        int x = 0;
        int dir = 1;
        Deque<int[]> route = new LinkedList<>();
        route.offerFirst(new int[]{y,x});
        boolean[][] snake = new boolean[n][n];
        snake[y][x] = true;
        int result = 0;
        int timeIndex = 0;
        while(true){
//            System.out.println(result+" "+y+" "+x+" "+" "+dir);
            // 머리를 늘린다.
            result++;
            y += DY[dir];
            x += DX[dir];
            if(y < 0 || y >= n || x < 0 || x >= n || snake[y][x]){ // 자신 또는 벽에 부딪혔다면 게임을 끝낸다.
                break;
            }
            snake[y][x] = true;
            route.offerFirst(new int[]{y,x});
            if(!isApple[y][x]){ // 사과가 없다면 꼬리 한칸 줄인다.
                int[] position = route.pollLast();
                snake[position[0]][position[1]] = false;
            }
            if(isApple[y][x]){
                isApple[y][x] = false;
            }
            if(timeIndex < dirCnt && time[timeIndex] == result){
                char ch = nextDir[timeIndex++];
                if(ch == LEFT){
                    dir += 3;
                    dir %= 4;
                }
                if(ch == RIGHT){
                    dir += 1;
                    dir %= 4;
                }
            }
        }
        return result;
    }
}