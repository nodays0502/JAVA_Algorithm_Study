package Programmers.ETC;

public class 삼각_달팽이 {
    public int[] solution(int n) {
        int[] answer = makeMap(n);
        return answer;
    }

    private static final int[] DY = {1,0,-1};
    private static final int[] DX = {0,1,-1};
    private static final int EMPTY = 0;

    private static int[] makeMap(int n){
        int[][] map = new int[n][n];
        int num = 0;
        int y = 0;
        int x = 0;
        int dir = 0;
        while(y >= 0 && y < n && x >= 0 && x < n && map[y][x] == EMPTY){
            map[y][x] = ++num;
            y += DY[dir];
            x += DX[dir];
            if(y < 0 || y >= n || x < 0 || x >= n || map[y][x] != EMPTY){
                y -= DY[dir];
                x -= DX[dir];
                dir = (dir + 1) % 3;
                y += DY[dir];
                x += DX[dir];
            }
        }
        int[] result = new int[num];
        int index = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] == EMPTY){
                    break;
                }
                result[index++] = map[i][j];
            }
        }
        return result;
    }
}
