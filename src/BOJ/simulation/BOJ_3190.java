package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_3190 {
    private static class Node{
        int time;
        char dir;

        public Node(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String,Integer> stoi = Integer::parseInt;
        int n  =  stoi.apply(br.readLine());
        int k = stoi.apply(br.readLine());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine());
            int y = stoi.apply(st.nextToken());
            int x = stoi.apply(st.nextToken());
            map[y-1][x-1] = 9;
        }
        int m = stoi.apply(br.readLine());
        Node[] input = new Node[m];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int y = stoi.apply(st.nextToken());
            char x = st.nextToken().charAt(0);
            input[i] = new Node(y,x);
        }
        System.out.println(move(map,input,n,m));
    }
    private static final int[] dy = {-1,0,1,0}; // 시작 dir = 1
    private static final int[] dx = {0,1,0,-1};
    private static void print(int[][] arr, int n ){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static int move(int[][] map , Node[]input,int n,int m){
        int time = 1;
        int ny = 0;
        int nx = 0;
        int dir = 1;
        int moveIndex = 0;
        map[ny][nx] = 1;
        Queue<int[]> prev = new LinkedList<>();
        prev.offer(new int[] {0,0});
        while(true){
//            print(map,n);
            ny += dy[dir];
            nx += dx[dir];
//            System.out.println(time+" "+ny+" "+nx+" "+dir);
            if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                break;
            }
            if(map[ny][nx] == 1){
                break;
//                int[] lastPrev = prev.poll();
//                if(!(ny == lastPrev[0] && nx == lastPrev[1])){
//                    break;
//                }
//                prev.add(new int[] {ny,nx});
//                map[lastPrev[0]][lastPrev[1]] = 0;
            } else if(map[ny][nx] == 9){
                map[ny][nx] = 1;
                prev.add(new int[] {ny,nx});
            } else if(map[ny][nx] == 0){
                map[ny][nx] = 1;
                int[] lastPrev = prev.poll();
                map[lastPrev[0]][lastPrev[1]] = 0;
                prev.add(new int[] {ny,nx});
            }
            if(moveIndex < m && input[moveIndex].time == time){
                if(input[moveIndex].dir == 'L'){
                    dir += 3;
                }
                if(input[moveIndex].dir == 'D'){
                    dir += 1;
                }
                dir %= 4;
                moveIndex++;
            }
            time++;
        }
        return time;
    }
}
