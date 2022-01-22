package BOJ.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        int result  = 0;
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                result += dfs(map,i,j);
            }
        }
        System.out.println(result);
    }
    static final int dy[] = {1,0};
    static final int dx[] = {0,1};
    static private class Node{
        int y;
        int x;
        int numS;

        public Node(int y, int x, int numS) {
            this.y = y;
            this.x = x;
            this.numS = numS;
        }
    }
    private static int dfs(char[][] map, int y, int x) {
        int result = 0;
        Queue<Node> q = new LinkedList<>();
        if (map[y][x] == 'S') {
            q.offer(new Node(y,x,1));
        }else{
            q.offer(new Node(y,x,0));
        }
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size; s++){
                Node now = q.poll();
                if(time == 7 && now.numS >= 4){
                    result++;
                }
                if(time < 7){
                    for(int i = 0 ; i < 2; i++){
                        int ny = now.y + dy[i];
                        int nx = now.x + dx[i];
                        if(ny >= 0 && ny < SIZE && nx >= 0 && nx < SIZE){
                            if(map[ny][nx] == 'S'){
                                q.offer(new Node(ny,nx,now.numS+1));
                            }else{
                                q.offer(new Node(ny,nx,now.numS));
                            }
                        }
                    }
                }
            }
            time++;
        }
        return result;
    }
}
