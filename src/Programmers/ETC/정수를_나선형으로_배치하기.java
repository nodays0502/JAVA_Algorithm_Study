package Programmers.ETC;

public class 정수를_나선형으로_배치하기 {
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    public int[][] solution(int n) {
        int[][] answer = makeMap(n);
        return answer;
    }
    private static int[][] makeMap(int n){
        int[][] answer = new int[n][n];
        int y = 0;
        int x = 0;
        int num = 1;
        int dir = 1;
        while(y >= 0 && y < n && x >= 0 && x < n){
            if(answer[y][x] != 0){
                break;
            }
            answer[y][x] = num++;
            y += DY[dir];
            x += DX[dir];
            if(x < 0 || x >= n || y < 0 || y >= n || answer[y][x] != 0){
                y -= DY[dir];
                x -= DX[dir];
                dir = (dir+1) % 4;
                y += DY[dir];
                x += DX[dir];
            }
        }
        return answer;
    }
}
