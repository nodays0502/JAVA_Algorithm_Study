package Programmers.ETC;

public class 안전지대 {
    private static final int EMPTY = 0;
    private static final int BOMB = 1;
    private static final int[] DY = {-1,0,1,0,-1,1,1,-1};
    private static final int[] DX = {0,1,0,-1,1,1,-1,-1};
    public int solution(int[][] board) {
        int answer = 0;
        int size = board.length;
        int[][] check = new int[size][size];
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(board[i][j] == BOMB){
                    checkBomb(i,j,check,size);
                }
            }
        }
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(check[i][j] == EMPTY){
                    answer++;
                }
            }
        }
        return answer;
    }
    private void checkBomb(int y, int x, int[][] check, int size){
        for(int i = 0 ; i < 8 ; i++){
            int ny = y + DY[i];
            int nx = x + DX[i];
            if(ny >= 0 && ny < size && nx >= 0 && nx < size){
                check[ny][nx] = BOMB;
            }
        }
        check[y][x] = BOMB;
    }
}
