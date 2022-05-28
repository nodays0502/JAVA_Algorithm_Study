package Programmers.ETC;

public class 방문_길이 {
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char RIGHT = 'R';
    private static final char LEFT = 'L';

    private static final int SIZE = 5;

    public int solution(String dirs) {
        int answer = cal(dirs);
        return answer;
    }

    private int cal(String dirs){
        int result = 0;
        int y = 0;
        int x = 0;
        boolean[][][] visited = new boolean[2 * SIZE + 2][2 * SIZE + 2][4];
        for(int i = 0 ; i < dirs.length() ; i++){
            char dirCh = dirs.charAt(i);
            int dir = detectDir(dirCh);
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(checkBound(ny,nx)){
                if(!visited[y+SIZE][x+SIZE][dir]){
                    result++;
                    visited[y+SIZE][x+SIZE][dir] = true;
                    visited[ny+SIZE][nx+SIZE][(dir+2)%4] = true;
                }
                y = ny;
                x = nx;
            }
        }
        return result;
    }
    private static int detectDir(char dirCh){
        if(dirCh == UP){
            return 2;
        }
        if(dirCh == DOWN){
            return 0;
        }
        if(dirCh == RIGHT){
            return 1;
        }
        if(dirCh == LEFT){
            return 3;
        }
        return -1;
    }
    private static boolean checkBound(int y,int x){
        if(y >= -SIZE && y <= SIZE && x >= -SIZE && x <= SIZE){
            return true;
        }
        return false;
    }
}
