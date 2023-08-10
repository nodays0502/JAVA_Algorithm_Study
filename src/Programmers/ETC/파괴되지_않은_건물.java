package Programmers.ETC;

public class 파괴되지_않은_건물 {
    private static final int ATTACK = 1;
    private static final int HEAL = 2;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] prefixSum = new int[n][m];
        for(int[] intArr : skill){
            int type = intArr[0];
            int r1 = intArr[1];
            int c1 = intArr[2];
            int r2 = intArr[3];
            int c2 = intArr[4];
            int degree = intArr[5];
            if(type == ATTACK){
                degree *= -1;
            }
            prefixSum[r1][c1] += degree;
            if(c2 + 1 < m){
                prefixSum[r1][c2+1] -= degree;
            }
            if(r2 + 1 < n){
                prefixSum[r2+1][c1] -= degree;
            }
            if(r2 + 1 < n && c2 + 1 < m){
                prefixSum[r2+1][c2+1] += degree;
            }
        }
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = 0 ; j < m ; j++){
                sum += prefixSum[i][j];
                prefixSum[i][j] = sum;
            }
        }
        for(int i = 0 ; i < m ; i++){
            int sum = 0;
            for(int j = 0 ; j < n ; j++){
                sum += prefixSum[j][i];
                prefixSum[j][i] = sum;
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] + prefixSum[i][j] > 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}
