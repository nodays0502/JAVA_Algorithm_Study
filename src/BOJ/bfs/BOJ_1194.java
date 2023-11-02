package BOJ.bfs;

import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.HashSet;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.Set;
    import java.util.StringTokenizer;

public class BOJ_1194 {

    private static final char EMPTY = '.';
    private static final char BLOCK = '#';
    private static final char END = '1';
    private static final char START = '0';
    private static final int NOT_FOUND = -1;
    private static final int KEY_SIZE = 6;
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        int startY = 0;
        int startX = 0;
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            for(int j = 0 ; j < m ; j++){
                map[i][j] = command.charAt(j);
                if(map[i][j] == START){
                    startY = i;
                    startX = j;
                    map[i][j] = EMPTY;
                }
            }
        }
        int result = bfs2(startY,startX,map,n,m);
        System.out.println(result);
    }
    private static class Node{
        int y;
        int x;
        boolean[] key;
        public Node(int y, int x, boolean[] key){
            this.y = y;
            this.x = x;
            this.key = key;
        }
        public String toString(){
            return y+"/"+x+"/"+ Arrays.toString(key);
        }
    }
    private static int bfs2(int startY, int startX, char[][] map, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startY,startX,0});
        boolean[][][] visited = new boolean[n][m][(int)Math.pow(2,KEY_SIZE)+1];
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(map[now[0]][now[1]] == END){
                    return time;
                }
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    int key = now[2];
                    if(ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != BLOCK){
                        if(map[ny][nx] >= 'a' && map[ny][nx] <= 'f' && !checkHaveKey(key,map[ny][nx]-'a')){ // 키라면
                            key += findKeyValue(map[ny][nx]-'a');
                        }
                        if(map[ny][nx] >= 'A' && map[ny][nx] <= 'F' && !checkHaveKey(key,map[ny][nx]-'A')){ // 문이라면 키가 있는지 확인
                            continue;
                        }
                        if(!visited[ny][nx][key]){
                            visited[ny][nx][key] = true;
                            q.offer(new int[]{ny,nx,key});
                        }
                    }
                }
            }
            time++;
        }
        return NOT_FOUND;
    }
    private static int findKeyValue(int num){
        return (int)Math.pow(2,num);
    }
    private static boolean checkHaveKey(int key,int num){
        while(num > 0){
            key /= 2;
            num--;
        }
        if(key % 2 == 1){
            return true;
        }else{
            return false;
        }
    }
    private static int bfs(int startY, int startX, char[][] map, int n, int m) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startY,startX,new boolean[KEY_SIZE]));
        Set<String> visited = new HashSet<>();
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                Node now = q.poll();
//                System.out.println(now.toString());
                if(map[now.y][now.x] == END){
                    return time;
                }
                for(int i = 0 ; i < 4 ; i++){
                    int ny = now.y + DY[i];
                    int nx = now.x + DX[i];
                    boolean[] key = Arrays.copyOf(now.key,KEY_SIZE);
                    if(ny >= 0 && ny < n && nx >= 0 && nx < m && map[ny][nx] != BLOCK){
                        if(map[ny][nx] >= 'a' && map[ny][nx] <= 'f'){ // 키라면
                            key[map[ny][nx]-'a'] = true;
                        }
                        if(map[ny][nx] >= 'A' && map[ny][nx] <= 'F' && !key[map[ny][nx]-'A']){ // 문이라면 키가 있는지 확인
                            continue;
                        }
                        Node next = new Node(ny,nx,key);
                        if(!visited.contains(next.toString())){
                            visited.add(next.toString());
                            q.offer(next);
                        }
                    }
                }
            }
            time++;
        }
        return NOT_FOUND;
    }


}