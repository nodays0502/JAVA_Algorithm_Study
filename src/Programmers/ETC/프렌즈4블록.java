package Programmers.ETC;

public class 프렌즈4블록 {
    public int solution(int n, int m, String[] board) {
        int answer = 0;
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            map[i] = board[i].toCharArray();
        }
        while(checkConnected(map,n,m)){
            gravity(map,n,m);
        }
        answer = checkEmpty(map,n,m);
        return answer;
    }
    private int checkEmpty(char[][]map, int n , int m){
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == EMPTY){
                    result++;
                }
            }
        }
        return result;
    }
    private static final char EMPTY = '0';
    private static final int CHECK_SIZE = 2;
    private void print(char[][] map,int n , int m){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    private boolean checkConnected(char[][] map,int n , int m){
        boolean result = false;
        boolean[][] deleteBlock = new boolean[n][m];
        for(int i = 0 ; i < n - CHECK_SIZE + 1 ; i++){
            for(int j = 0 ; j < m - CHECK_SIZE + 1 ; j++){
                if(map[i][j] != EMPTY && checkType(map,i,j)){
                    result = true;
                    deleteBlock[i][j] = true;
                }
            }
        }
        if(!result){
            return false;
        }
        for(int i = 0 ; i < n - CHECK_SIZE + 1 ; i++){
            for(int j = 0 ; j < m - CHECK_SIZE + 1 ; j++){
                if(deleteBlock[i][j]){
                    delete(map,i,j);
                }
            }
        }
        return true;
    }
    private void delete(char[][]map,int y,int x){
        for(int i = y ; i < y + CHECK_SIZE ; i++){
            for(int j = x ; j < x + CHECK_SIZE ; j++){
                map[i][j] = EMPTY;
            }
        }
    }

    private boolean checkType(char[][]map,int y,int x){
        char type = map[y][x];
        for(int i = y ; i < y + CHECK_SIZE ; i++){
            for(int j = x ; j < x + CHECK_SIZE ; j++){
                if(map[i][j] != type){
                    return false;
                }
            }
        }
        return true;
    }
    private void gravity(char[][] map,int n,int m){
        for(int row = 0 ; row < m ; row++){
            int emptyIndex = n-1;
            for(int col = n-1 ; col >= 0 ; col--){
                if(map[col][row] != EMPTY){
                    char temp = map[emptyIndex][row];
                    map[emptyIndex][row] = map[col][row];
                    map[col][row] = temp;
                    emptyIndex--;
                }
            }
        }
    }
}
