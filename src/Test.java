import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
    private static final int[] DY = {0,0,-1,1};
    private static final int[] DX = {1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int[] command = new int[k];
        for(int i = 0 ; i < k ; i++){
            command[i] = Integer.parseInt(st.nextToken()) - 1;
        }
        cal(y,x,map,n,m,command,k);
//        int[][] dice = new int[][]{
//            {0,1,0},
//            {2,3,4},
//            {0,5,0},
//            {0,6,0}
//        };
//        moveDice(dice,0);
//        printDice(dice);
    }

    private static void printDice(int[][] dice) {
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                System.out.print(dice[i][j]);
            }
            System.out.println();
        }
    }


    private static void cal(int y, int x, int[][] map, int n, int m, int[] command, int k) {
        int[][] dice = new int[4][3];
        for(int dir : command){
            y += DY[dir];
            x += DX[dir];
            if(y < 0 || y >= n || x < 0 || x >= m){ // 바깥으로 이동하려할 때 무시
                y -= DY[dir];
                x -= DX[dir];
                continue;
            }
            moveDice(dice,dir);
            if(map[y][x] == 0){
                map[y][x] = dice[1][1];
            }else{
                dice[1][1] = map[y][x];
                map[y][x] = 0;
            }
            System.out.println(dice[3][1]);
        }
    }
    private static void moveDice(int[][] dice, int dir){
        if(dir == 2 || dir == 3){
            int nowIndex = 0;
            int prev = dice[nowIndex][1];
            for(int i = 0 ; i < 4 ; i++){
                int nextIndex = (nowIndex - DY[dir] + 4) % 4;
                int temp = dice[nextIndex][1];
                dice[nextIndex][1] = prev;
                prev = temp;
                nowIndex = nextIndex;
            }
        }else{
            int nowIndex = 0;
            int prev = dice[1][nowIndex];
            for(int i = 0 ; i < 4 ; i++){
                int nextIndex = (nowIndex - DX[dir] + 4) % 4;
                if(nextIndex == -1 || nextIndex == 3){
                    int temp = dice[3][1];
                    dice[3][1] = prev;
                    prev = temp;
                    nowIndex = nextIndex;
                    continue;
                }
                if(nextIndex == -2){
                    nextIndex = 2;
                }
                if(nextIndex == 4){
                    nextIndex = 0;
                }
                int temp = dice[1][nextIndex];
                dice[1][nextIndex] = prev;
                prev = temp;
                nowIndex = nextIndex;
            }
        }
    }

}