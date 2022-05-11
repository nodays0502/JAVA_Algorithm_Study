package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15685 {
    private static final int SIZE = 100;
    private static final int[] dy = {0,-1,0,1};
    private static final int[] dx = {1,0,-1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        boolean[][]map = new boolean[SIZE+1][SIZE+1];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = stoi.apply(st.nextToken());
            int y = stoi.apply(st.nextToken());
            int dir = stoi.apply(st.nextToken());
            int g = stoi.apply(st.nextToken());
            map[y][x] = true;
            move(g,y,x,dir,map);
        }
        int result = check(map,n);
        System.out.println(result);
    }

    private static int check(boolean[][] map, int n) {
        int result = 0;
        for(int i = 0 ; i < SIZE  ; i++){
            for(int j = 0 ; j < SIZE  ; j++){
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]){
                    result++;
                }
            }
        }
        return result;
    }

    private static final int LEFT = 1;
    private static final int RIGHT = 3;
    private static void move(int g, int y, int x, int dir,boolean[][] map) {
//        System.out.println("start");
//        System.out.println(y+" "+x+" "+dir);
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        map[ny][nx] = true;
        LinkedList<Integer> list = new LinkedList<>();
        list.offerFirst(dir);
//        System.out.println(ny+" "+nx+" "+dir);
        for(int i = 1 ; i <= g ; i++){
            int size = list.size();
            for(int j = size-1 ; j >= 0 ; j--){
                int nowDir = (list.get(j) + LEFT) % 4;
                ny += dy[nowDir];
                nx += dx[nowDir];
                map[ny][nx] = true;
//                System.out.println(i+" "+ny+" "+nx+" "+nowDir);
                list.offer(nowDir);
            }
        }
    }
}
