package Programmers.ETC;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 빛의_경로_사이클 {

    private static int GO_STRAIGHT = 0;
    private static int TURN_LEFT = 3;
    private static int TURN_RIGHT = 1;
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};

    public int[] solution(String[] grid) {

        int n = grid.length;
        int m = grid[0].length();
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            map[i] = grid[i].toCharArray();
        }
        boolean[][][] isCycle = new boolean[n][m][4];
        boolean[][][] visited = new boolean[n][m][4];
        List<Integer> result = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int dir = 0 ; dir < 4; dir++){
                    if(!visited[i][j][dir]){
                        result.add(checkCycle(i,j,dir,map,visited,n,m));
                    }
                }
            }
        }
        Collections.sort(result);
        int[] answer = new int[result.size()];
        int index = 0;
        for(int temp : result){
            answer[index++] = temp;
        }
        return answer;
    }
    private String checkString(int y, int x, int dir){
        return y+","+x+","+dir;
    }
    private int checkCycle(int y, int x,int dir, char[][]map,
        boolean[][][]visited,int n,int m){
        int ny = y;
        int nx = x;
        int cnt = 0;
        Map<String,Integer> checkVisited = new HashMap<>();
        while(true){
            visited[ny][nx][dir] = true;
            String temp = checkString(ny,nx,dir);
            if(checkVisited.containsKey(temp)){
                int value = checkVisited.get(temp);
                return cnt-value;
            }
            checkVisited.put(temp,cnt);
            dir = nextDir(dir,map[ny][nx]);
            ny = nextPosition(ny,dy[dir],n);
            nx = nextPosition(nx,dx[dir],m);
            cnt++;
        }
    }
    private int nextDir(int dir, char value){
        if(value == 'S'){
            return dir;
        }
        if(value == 'R'){
            return (dir + TURN_RIGHT) % 4;
        }
        if(value == 'L'){
            return (dir + TURN_LEFT) % 4;
        }
        return -1;
    }
    private int nextPosition(int y,int delta,int size){
        return (y + delta + size) % size;
    }
    private static boolean checkBound(int y , int x, int size){
        if(y >= 0 && y < size && x >= 0 && x < size){
            return true;
        }
        return false;
    }
}
