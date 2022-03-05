package Programmers.KAKAO_INTERN_2021;

public class 거리두기_확인하기 {
    private static final int SIZE = 5;
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,-1,0,1};
    private static final int DEPTH_LIMIT = 2;
    private static int cal(String[]place){
        char[][] arr = new char[SIZE][];
        for(int i = 0 ; i < 5 ; i++){
            arr[i] = place[i].toCharArray();
        }
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                if(arr[i][j] == 'P' && !checkRule(0,i,j,-1,arr)){
                    return 0;
                }
            }
        }
        return 1;
    }
    private static boolean checkRule(int depth , int y,int x,int dir,char[][] arr){
        if(dir != -1 && arr[y][x] == 'P'){
            return false;
        }
        if(depth == DEPTH_LIMIT){
            return true;
        }
        if(dir != -1){
            dir += 2;
            dir %= 4;
        }
        for(int i = 0 ; i < 4 ; i++){
            if(dir == i){
                continue;
            }
            int ny = y + dy[i];
            int nx = x + dx[i];
            if( ny >= 0 && ny < SIZE && nx >= 0 && nx < SIZE
                && arr[ny][nx] != 'X' && !checkRule(depth+1,ny,nx,i,arr)){
                return false;
            }
        }
        return true;
    }
    public int[] solution(String[][] places) {
        int pLength = places.length;
        int[] answer = new int[pLength];
        for(int i = 0 ; i < pLength ; i++){
            answer[i] = cal(places[i]);
        }
        return answer;
    }
}
