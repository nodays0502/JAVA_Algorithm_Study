package BOJ.Simulation;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21608 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        int[][] friend = new int[n*n+1][4];
        for(int i = 0 ; i < n*n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = stoi.apply(st.nextToken());
            for(int j = 0 ; j < 4; j++){
                friend[num][j] = stoi.apply(st.nextToken());
            }
            position(map,num,friend[num],n);
        }
        int result = calValue(map,n,friend);
//        print(map,n);
        System.out.println(result);
    }

    private static final int[] SCORE = {0,1,10,100,1000};
    private static void print(int[][] map, int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static int calValue(int[][] map, int n, int[][] friend) {
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int num = map[i][j];
                int[] cnt = checkValue(i,j,map,n,friend[num]);
                result += SCORE[cnt[0]];
            }
        }
        return result;
    }

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    private static void position(int[][] map, int num, int[] friend,int n) {
        int resultY = 0;
        int resultX = 0;
        int resultFriendCnt = -1;
        int resultEmptyCnt = -1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] != 0){
                    continue;
                }
                int[] cnt = checkValue(i,j,map,n,friend);
                if(resultFriendCnt < cnt[0]){
                    resultFriendCnt = cnt[0];
                    resultEmptyCnt = cnt[1];
                    resultY = i;
                    resultX = j;
                }else if(resultFriendCnt == cnt[0] && resultEmptyCnt < cnt[1]){
                    resultEmptyCnt = cnt[1];
                    resultY = i;
                    resultX = j;
                }
            }
        }
        map[resultY][resultX] = num;
    }

    private static int[] checkValue(int y, int x, int[][] map,int n,int[] friend) {
        int friendCnt = 0;
        int emptyCnt = 0;
        for(int i = 0 ; i < 4 ; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(checkBound(ny,nx,n)){
                if(map[ny][nx] == 0){
                    emptyCnt++;
                    continue;
                }
                for(int j = 0 ; j < 4 ; j++){
                    if(friend[j] == map[ny][nx]){
                        friendCnt++;
                        break;
                    }
                }
            }
        }
        return new int[] {friendCnt,emptyCnt};
    }

    private static boolean checkBound(int ny, int nx, int n) {
        if(ny >= 0 && ny < n && nx >= 0 && nx < n){
            return true;
        }
        return false;
    }
}
