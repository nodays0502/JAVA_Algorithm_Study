package Programmers.ETC;

public class 공원_산책 {

    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static final String[] DIR = {"N","E","S","W"};
    private static final char START = 'S';
    private static final char EMPTY = 'O';
    private static final char BLOCK = 'X';

    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        int[] answer = {};
        char[][] map = makeMap(park);
        int y = 0;
        int x = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == START){
                    y = i;
                    x = j;
                }
            }
        }
        for(String route : routes){
            String[] temp = route.split(" ");
            String dir = temp[0];
            int dirNum = 0;
            for(int i = 0 ; i < 4 ; i++){
                if(DIR[i].equals(dir)){
                    dirNum = i;
                    break;
                }
            }
            int length = Integer.parseInt(temp[1]);
            int ny = y;
            int nx = x;
            for(int i = 0 ; i < length ; i++){
                ny += DY[dirNum];
                nx += DX[dirNum];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || map[ny][nx] == BLOCK){
                    ny = y;
                    nx = x;
                    break;
                }
            }
            y = ny;
            x = nx;
        }
        answer = new int[]{y,x};
        return answer;
    }
    private static char[][] makeMap(String[] park){
        int n = park.length;
        int m = park[0].length();
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                map[i][j] = park[i].charAt(j);
            }
        }
        return map;
    }
}
