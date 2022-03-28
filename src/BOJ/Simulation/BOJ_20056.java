package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_20056 {
    private static class Node{
        int y;
        int x;
        int weight;
        int speed;
        int dir;

        public Node(int y, int x, int weight, int speed, int dir) {
            this.y = y;
            this.x = x;
            this.weight = weight;
            this.speed = speed;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());

        Queue<Node> input = new LinkedList<>();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int y = stoi.apply(st.nextToken())-1;
            int x = stoi.apply(st.nextToken())-1;
            int weight = stoi.apply(st.nextToken());
            int dir = stoi.apply(st.nextToken());
            int speed = stoi.apply(st.nextToken());
            input.offer(new Node(y,x,weight,dir,speed));
        }
        for(int i = 0 ; i < k ; i++){
            move(input,n);
        }
        int weightSum = 0;
        while(!input.isEmpty()){
            weightSum += input.poll().weight;
        }
        System.out.println(weightSum);
    }
    private static List<Node>[][] initMap(int n){
        List<Node>[][]map = new List[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                map[i][j] = new ArrayList<Node>();
            }
        }
        return map;
    }
    private static void move(Queue<Node> input, int n) {
        List<Node>[][] map = initMap(n);
        List<Node>nextInput = new ArrayList<>();
        while(!input.isEmpty()){
            moveFire(input.poll(),map,n);
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j].size() > 1){
                    conflict(i,j,map,input);
                }else if(map[i][j].size() == 1){
                    input.offer(map[i][j].get(0));
                }
            }
        }
    }

    private static void conflict(int y, int x, List<Node>[][] map, Queue<Node> input) {
        int weightSum = 0;
        int speedSum = 0;
        int size = map[y][x].size();
        int remainder = 0;
        boolean flag = true;
        for(int i = 0 ; i < map[y][x].size() ; i++){
            Node node = map[y][x].get(i);
            weightSum += node.weight;
            speedSum += node.speed;
            if(i == 0){
                remainder = node.dir % 2;
            }else if(flag){
                if(remainder != node.dir % 2){
                    flag = false;
                }
            }
        }
        if(weightSum /5 == 0){
            return;
        }
        for(int i = 0 ; i < 4 ; i++){
            int dir = 2*i;
            if (!flag) {
                dir += 1;
            }
            input.offer(new Node(y,x,weightSum/5,speedSum/size,dir));
        }
    }

    private static final int[] dy = {-1,-1,0,1,1,1,0,-1};
    private static final int[] dx = {0,1,1,1,0,-1,-1,-1};
    private static void moveFire(Node node,  List<Node>[][] map, int n) {
        int ny = (node.y + dy[node.dir] * node.speed + n * node.speed) % n;
        int nx = (node.x + dx[node.dir] * node.speed + n * node.speed) % n;
        map[ny][nx].add(new Node(ny,nx,node.weight, node.speed, node.dir));
    }
}
