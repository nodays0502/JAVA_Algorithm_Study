package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_20005 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int cnt = stoi.apply(st.nextToken());
        char[][] map = new char[n][m];
        for(int i = 0 ; i < n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = str.charAt(j);
            }
        }
        Map<Character,Integer> dps = new HashMap<> ();
        for(int i = 0 ; i < cnt ; i++){
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int damage = stoi.apply(st.nextToken());
            dps.put(ch,damage);
        }
        int hp = stoi.apply(br.readLine());
        int result = cal(map,n,m,dps,hp);
        System.out.println(result);
    }
    private static final char EMPTY = '.';
    private static final char BLOCK = 'X';
    private static final char BOSS = 'B';
    private static class Node{
        char ch;
        int time;

        public Node(char ch, int time) {
            this.ch = ch;
            this.time = time;
        }
    }
    private static int cal(char[][] map, int n, int m, Map<Character, Integer> dps, int hp) {
        int cnt = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((v1,v2)->{
            return v1.time - v2.time;
        });
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] != EMPTY && map[i][j] != BLOCK && map[i][j] != BOSS){
                    int time = bfs(i,j,n,m,map);
                    pq.offer(new Node(map[i][j],time));
                }
            }
        }
        int prevTime = 0;
        int damageSum = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            hp -= damageSum * (node.time - prevTime);
            if(hp <= 0){
                break;
            }
            cnt++;
            prevTime = node.time;
            damageSum += dps.get(node.ch);
        }
        return cnt;
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static int bfs(int y, int x, int n,int m,char[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        boolean[][]visited = new boolean[n][m];
        visited[y][x] = true;
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(map[now[0]][now[1]] == BOSS){
                    return time;
                }
                for(int i = 0 ; i < 4; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != BLOCK && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
            time++;
        }
        return -1;
    }

}
