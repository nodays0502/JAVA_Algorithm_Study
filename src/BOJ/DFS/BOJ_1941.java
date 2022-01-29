package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1941 {
    static final int SIZE = 5;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[SIZE][SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < SIZE ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        int result  = cal(map);
        System.out.println(result);
    }
    static final int dy[] = {-1,0,1,0};
    static final int dx[] = {0,1,0,-1};
    private static int cal(char[][] map){
        int result = 0;
        int[] choice = new int[7];
        result = comb(0,choice,0,map);
        return result;
    }
    private static int comb(int depth, int[] choice, int start,char[][] map){ // 7명 뽑기
        if(depth == 7){
//            System.out.println(Arrays.toString(choice));
            if(checkCountS(choice,map) && checkNear(choice)){
                return 1;
            }
            return 0;
        }
        int result = 0;
        for(int i = start ; i < SIZE * SIZE ; i++){
            choice[depth] = i;
            result += comb(depth+1, choice,i + 1,map);
        }
        return result;
    }
    private static boolean checkCountS(int[] choice, char[][]map){
        int count = 0;
        for(int num : choice){
            int y = num / SIZE;
            int x = num % SIZE;
            if(map[y][x] == 'S'){
                count++;
            }
        }
        if(count >= 4){
            return true;
        }
        return false;
    }
    private static boolean checkNear(int[] choice) { // 인접한지 확인
        boolean[][] visited = new boolean[SIZE][SIZE];
        boolean[][] needVisited = new boolean[SIZE][SIZE];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < 7 ; i++){
            int y = choice[i] / SIZE;
            int x = choice[i] % SIZE;
            if(i == 0){
                queue.offer(new int[] {y,x});
                visited[y][x] = true;
            }
            needVisited[y][x] = true;
        }
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0; i < 4; i++){
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                if(ny >= 0 && ny < SIZE && nx >= 0 && nx < SIZE && needVisited[ny][nx] && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.offer(new int[] {ny,nx});
                }
            }
        }
        for(int num : choice){
            int y = num / SIZE;
            int x = num % SIZE;
            if(visited[y][x] != needVisited[y][x]){
                return false;
            }
        }
        return true;
    }
}
