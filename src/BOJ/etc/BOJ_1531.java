package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1531 {
    private static final int SIZE = 100;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] cnt = new int[SIZE+1][SIZE+1];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken())-1;
            int startX = Integer.parseInt(st.nextToken())-1;
            int endY = Integer.parseInt(st.nextToken())-1;
            int endX = Integer.parseInt(st.nextToken())-1;
            appendPaper(cnt,startY,startX,endY,endX);
        }
        int result = countMoreM(cnt,m);
        System.out.println(result);
    }

    private static int countMoreM(int[][] cnt, int m) {
        int result = 0;
        for(int i = 0 ; i <= SIZE; i++){
            for(int j = 0 ; j <= SIZE ; j++){
                if(cnt[i][j] > m ){
                    result++;
                }
            }
        }
        return result;
    }

    private static void appendPaper(int[][] cnt, int startY, int startX, int endY, int endX) {
        for(int i = startY ; i <= endY; i++){
            for(int j = startX ; j <= endX ; j++){
                cnt[i][j]++;
            }
        }
    }
}
