package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

public class BOJ_1944 {
    private static final int INF = 987654321;
    private static int prim(char[][] map, int n, int m){
        int[][] distance = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(distance[i],INF);
        }
        List<int[]> keyPosition = new ArrayList<>();
        boolean[] visited = new boolean[m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] == 'S'){
                    calDistance(i,j,map,n,distance);
                }
                if(map[i][j] == 'K'){
                    keyPosition.add(new int[] {i,j});
                }
            }
        }
        int result = 0;
        for(int i = 0 ; i < m ; i++){
            int minIndex = 0;
            int minValue = INF;
            for(int j = 0 ; j < m ; j++){
                int y = keyPosition.get(j)[0];
                int x = keyPosition.get(j)[1];
                if(!visited[j] && minValue > distance[y][x]){
                    minValue = distance[y][x];
                    minIndex = j;
                }
            }
            if(minValue == INF){
                return -1;
            }
            visited[minIndex] = true;
            result += minValue;

            int y = keyPosition.get(minIndex)[0];
            int x = keyPosition.get(minIndex)[1];
            calDistance(y,x,map,n,distance);
        }
        return result;
    }

    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};

    private static void calDistance(int y, int x, char[][] map, int n, int[][] distance){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {y,x});
        int time = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                for(int i = 0 ; i < 4; i++){
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < n && map[ny][nx] != '1' && distance[ny][nx] > time){
                        distance[ny][nx] = time;
                        q.offer(new int[] {ny,nx});
                    }
                }
            }
            time++;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        String command = br.readLine();
        String [] temp = command.split(" ");
        int n = stoi.apply(temp[0]);
        int m = stoi.apply(temp[1]);
        char[][] map = new char[n][n];
        for(int i = 0 ; i < n ; i++){
            command = br.readLine();
            for(int j = 0 ; j < n ; j++){
                map[i][j] = command.charAt(j);
            }
        }
        System.out.println(prim(map,n,m));
    }
}
