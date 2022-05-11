package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

public class BOJ_14442 {
    static final int[] dy = {-1,0,1,0};
    static final int[] dx = {0,1,0,-1};
    static private class Node{
        int y;
        int x;
        int cnt;

        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
    private static int bfs(int[][] map, int n , int m, int k){
        boolean[][][] visited = new boolean[n][m][k+1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,0));
        int time = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                Node now = q.poll();
                int y = now.y;
                int x = now.x;
                int cnt = now.cnt;
//                System.out.println(y+" "+x+" "+cnt);
                if(y == n-1 && x == m-1){
                    return time;
                }
                for(int i = 0 ; i < 4 ; i++){
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < m){
                        if(map[ny][nx] == 1 && cnt < k && !visited[ny][nx][cnt+1]){
                            q.offer(new Node(ny,nx,cnt+1));
                            visited[ny][nx][cnt+1] = true;
                        }else if(map[ny][nx] == 0 && !visited[ny][nx][cnt]){
                            q.offer(new Node(ny,nx,cnt));
                            visited[ny][nx][cnt] = true;
                        }
                    }
                }
            }
            time++;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        String[] str = command.split(" ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(str[0]);
        int m = stoi.apply(str[1]);
        int k = stoi.apply(str[2]);
        int[][] map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(command.charAt(j)+"");
            }
        }
        System.out.println(bfs(map,n,m,k));
    }
}
