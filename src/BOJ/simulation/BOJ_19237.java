package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_19237 {

    private static class Smell{
        int num;
        int time;

        public Smell(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
    private static class Shark{
        int num;
        int y;
        int x;
        int dir;
        int[][] priorityDir;
        public void setDir(int dir){
            this.dir = dir;
        }
        public Shark(int num,int y, int x) {
            this.num = num;
            this.y = y;
            this.x = x;
            priorityDir = new int[4][4];
        }

        public void setPriorityDir(int index, int[] arr) {
            this.priorityDir[index] = arr;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        Shark[] input = new Shark[m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
                if(map[i][j] != 0){
                    input[map[i][j]-1] = new Shark(map[i][j],i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < m ; i++){
            int dir = stoi.apply(st.nextToken()) - 1;
            input[i].setDir(dir);
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < 4 ; j++){
                st = new StringTokenizer(br.readLine()," ");
                int[] tempDir = new int[4];
                Shark shark = input[i];
                for(int l = 0 ; l < 4 ; l++){
                    tempDir[l] = stoi.apply(st.nextToken())-1;
                }
                shark.setPriorityDir(j,tempDir);
            }
        }
        int result = cal(map,input,n,m,k);
        System.out.println(result);
    }

    private static int cal(int[][] map, Shark[] input, int n, int m, int k) {
        int time = 0;
        Smell[][] smell = new Smell[n][n];
        Queue<Shark> q = new LinkedList<>();
        for(int i = 0 ; i < m; i++){
            q.offer(input[i]);
            smell[input[i].y][input[i].x] = new Smell(input[i].num,-1);
        }
        while(q.size() > 1){
            int size = q.size();
//            System.out.println(size);
//            print(map,n);
//            System.out.println();
//            printSmell(smell,n);
            for(int s = 0 ; s < size ; s++){
                Shark now = q.poll();
                if(move(now,map,n,smell,time)){
                    q.offer(now);
                }
//                System.out.println(now.num+" "+now.y+" "+now.x);
            }
            makeSmell(smell,time,q);
            time++;
            removeSmell(smell,n,time,k);
            if(time > 1_000){
                return -1;
            }
        }
        return time;
    }

    private static void makeSmell(Smell[][] smell, int time, Queue<Shark> q) {
        int size = q.size();
        for(int i = 0 ; i < size ; i++){
            Shark now = q.poll();
            smell[now.y][now.x] = new Smell(now.num,time);
            q.offer(now);
        }
    }

    private static void removeSmell(Smell[][] smell, int n, int time, int k) {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(smell[i][j] != null && smell[i][j].time < time - k){
                    smell[i][j] = null;
                }
            }
        }
    }
    private static void printSmell(Smell[][] smell, int n) {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(smell[i][j]!= null){
                    System.out.print(smell[i][j].num+" ");
                }else{
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }
    private static void print(int[][] arr, int n) {
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static final int[] dy = {-1,1,0,0};
    private static final int[] dx = {0,0,-1,1};
    private static boolean move(Shark now, int[][] map, int n,Smell[][] smell,int time) {
        int dir = now.dir;
        int num = now.num;
        for(int i = 0 ; i < 4 ; i++){ // 0
            int nextDir = now.priorityDir[dir][i];
            int ny = now.y + dy[nextDir];
            int nx = now.x + dx[nextDir];
            if(ny >= 0 && ny < n && nx >= 0 && nx < n ){
                if(smell[ny][nx] != null){
                    continue;
                }
                if(map[ny][nx] != 0 && map[ny][nx] < num){
                    map[now.y][now.x] = 0;
                    return false;
                }
                map[ny][nx] = num;
                map[now.y][now.x] = 0;
//                smell[ny][nx] = new Smell(num,time);
                now.y = ny;
                now.x = nx;
                now.dir = nextDir;
                return true;
            }
        }
        for(int i = 0 ; i < 4 ; i++){ // 자신 냄새
            int nextDir = now.priorityDir[dir][i];
            int ny = now.y + dy[nextDir];
            int nx = now.x + dx[nextDir];
            if(ny >= 0 && ny < n && nx >= 0 && nx < n && smell[ny][nx].num == num){
//                System.out.println("smell same "+smell[ny][nx].num+" "+num);
//                System.out.println(ny+" "+nx);
                map[ny][nx] = num;
                map[now.y][now.x] = 0;
//                smell[ny][nx] = new Smell(num,time);
                now.y = ny;
                now.x = nx;
                now.dir = nextDir;
                return true;
            }
        }
        return true;
    }
}
