package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17837 {
    private static class Node{
        int y;
        int x;
        int dir;

        public Node(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] board = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                board[i][j] = stoi.apply(st.nextToken());
            }
        }
        Node[] input = new Node[m];
        String[][] map = new String[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                map[i][j] = "";
            }
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int y = stoi.apply(st.nextToken())-1;
            int x = stoi.apply(st.nextToken())-1;
            int dir = changeDir(stoi.apply(st.nextToken()));
            input[i] = new Node(y,x,dir);
            map[y][x] = Integer.toString(i);
        }
        int time = 0;
        int cnt = 0;
//        print(map,n);
        while(cnt < 4){
            map = move(map,board,input,n,m);
            cnt = checkCnt(map,n);
            time++;
            if(time > 1000){
                break;
            }
//            print(map,n);
        }
        if(time > 1000){
            System.out.println(-1);
        }else{
            System.out.println(time);
        }
    }

    private static int checkCnt(String[][] map, int n) {
        int result = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                result = Math.max(result,map[i][j].length());
            }
        }
        return result;
    }

    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};

    private static int changeDir(int dir) {
        if(dir == 1){
            return 1;
        }
        if(dir == 2){
            return 3;
        }
        if(dir == 3){
            return 0;
        }
        if(dir == 4){
            return 2;
        }
        return -1;
    }
    private static void print(String[][] arr,int n){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j].equals("")){
                    System.out.print("- ");
                }else{
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    private static String[][] move(String[][] map, int[][] board, Node[] input, int n, int m) {
        for(int i = 0 ; i < m ; i++){
            Node now = input[i];
            int y = now.y;
            int x = now.x;
            int dir = now.dir;
            int index = map[y][x].indexOf(Integer.toString(i));
            String pone = map[y][x].substring(index , map[y][x].length());
            map[y][x] = map[y][x].substring(0,index);
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[ny][nx] == 2){ // 파랑
                dir = (dir + 2) % 4;
                input[i].dir = dir;
                ny += 2 * dy[dir];
                nx += 2 * dx[dir];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[ny][nx] == 2){ // 또 파랑
                    map[y][x] = (map[y][x] + pone);
                    continue;
                }
            }
            if(board[ny][nx] == 0){ // 흰
                map[ny][nx] += pone;
            }
            if(board[ny][nx] == 1){ // 빨강
                pone = new StringBuilder(pone).reverse().toString();
                map[ny][nx] += pone;
            }
            for(int j = 0 ; j < pone.length() ; j++){
                int element = pone.charAt(j) - '0';
                input[element].y = ny;
                input[element].x = nx;
            }
            if(map[ny][nx].length() >= 4){
                break;
            }
        }
        return map;
    }
}
