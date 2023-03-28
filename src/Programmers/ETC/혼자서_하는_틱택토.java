package Programmers.ETC;

public class 혼자서_하는_틱택토 {

    private static final char O = 'O';
    private static final char X = 'X';
    private static final char EMPTY = '.';
    private static final int RIGHT = 1;
    private static final int WRONG = 0;
    private static final int SIZE = 3;

    public int solution(String[] board) {
        int answer = cal(board);
        return answer;
    }
    private int cal(String[] board){
        char[][] map = new char[SIZE][SIZE];

        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        if(!checkRight(map)){
            return WRONG;
        }
        return RIGHT;
    }

    private int calWin(char[][] map,char ch){
        int cnt = 0;
        for(int i = 0 ; i < SIZE ; i++){
            if(map[i][0] == ch && map[i][0] == map[i][1] && map[i][1] == map[i][2]){
                cnt++;
            }
            if(map[0][i] == ch && map[0][i] == map[1][i] && map[1][i] == map[2][i]){
                cnt++;
            }
        }
        if(map[1][1] == ch && map[0][0] == map[1][1] && map[1][1] == map[2][2]){
            cnt++;
        }
        if(map[1][1] == ch && map[0][2] == map[1][1] && map[1][1] == map[2][0]){
            cnt++;
        }
        return cnt;

    }
    private boolean checkRight(char[][] map){
        int Ocnt = 0;
        int Xcnt = 0;
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                if(map[i][j] == O){
                    Ocnt++;
                }else if(map[i][j] == X){
                    Xcnt++;
                }
            }
        }
        if(Xcnt > Ocnt || Ocnt - Xcnt > 1){
            return false;
        }
        int OwinCnt = calWin(map,O);
        int XwinCnt = calWin(map,X);
        if(OwinCnt > 0 && XwinCnt > 0){
            return false;
        }
        if(OwinCnt > 0 && Ocnt == Xcnt){
            return false;
        }
        if(XwinCnt > 0 && Ocnt > Xcnt){
            return false;
        }
        return true;
    }
}
