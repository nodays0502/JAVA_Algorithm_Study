package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17143 {

    private static class Node {
        int speed;
        int dir;
        int weight;

        public Node(int speed, int dir, int weight) {
            this.speed = speed;
            this.dir = dir;
            this.weight = weight;
        }
    }

    private static final int[] dy = {-1, 0, 1, 0};
    private static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        Node[] input = new Node[k+1];
        int[][] map = new int[n][m];
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = stoi.apply(st.nextToken())-1;
            int x = stoi.apply(st.nextToken())-1;
            int speed = stoi.apply(st.nextToken());
            int dir = stoi.apply(st.nextToken());
            dir = changeDir(dir);
            int weight = stoi.apply(st.nextToken());
            map[y][x] = i;
            input[i] = new Node(speed, dir, weight);
        }
        int result = 0;
        for(int i = 0 ; i < m ; i++){
            result += catchShark(map,input,i,n);
//            System.out.println(result);
//            System.out.println(Arrays.deepToString(map));
            moveShark(map,input,n,m);
//            System.out.println(Arrays.deepToString(map));
        }
        System.out.println(result);
    }

    private static void moveShark(int[][] map, Node[] input, int n, int m) {
        int[][] temp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] != 0){
                    move(i,j,temp,map[i][j],input,n,m);
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                map[i][j] = temp[i][j];
            }
        }
    }

    private static void move(int y, int x, int[][] map,int num,Node[] input, int n, int m) {
        Node node = input[num];
        int speed = node.speed;
        int weight = node.weight;
        int dir = node.dir;
        for(int i = 0 ; i < speed ; i++){
            y += dy[dir];
            x += dx[dir];
            if(y < 0 || x < 0 || y >= n || x >= m){
                y -= 2 * dy[dir];
                x -= 2 * dx[dir];
                dir = (dir + 2) % 4;
            }
        }
        input[num].dir = dir;
        if(map[y][x] == 0){
            map[y][x] = num;
        }else{
            int temp = map[y][x];
            int tempWeight = input[temp].weight;
            if(tempWeight < weight){
                map[y][x] = num;
            }
        }
    }

    private static int catchShark(int[][] map,Node[] input, int x, int n) {
        for(int i = 0 ; i < n ; i++){
            if(map[i][x] != 0){
                int num = map[i][x];
                map[i][x] = 0;
                return input[num].weight;
            }
        }
        return 0;
    }

    private static int changeDir(int dir) {
        if (dir == 1) {
            return 0;
        }
        if (dir == 2) {
            return 2;
        }
        if (dir == 3) {
            return 1;
        }
        if (dir == 4) {
            return 3;
        }
        return -1;
    }
}
