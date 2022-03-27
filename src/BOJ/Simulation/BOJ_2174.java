package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2174 {
    private static final int[] dy = {-1,0,1,0};
    private static final int[] dx = {0,1,0,-1};
    private static final int LEFT = 3;
    private static final int RIGHT = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int m = stoi.apply(st.nextToken());
        int n = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int robotCnt = stoi.apply(st.nextToken());
        int commandCnt = stoi.apply(st.nextToken());
        List<int[]> robot = new ArrayList<>(robotCnt);
        int[][] map = new int[n][m];
        for(int i = 0 ; i < robotCnt ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = stoi.apply(st.nextToken()) - 1;
            int y = n - stoi.apply(st.nextToken());
            int dir = 0;
            String stringDir = st.nextToken();
            if("N".equals(stringDir)){
                dir = 0;
            }else if("E".equals(stringDir)){
                dir = 1;
            }else if("S".equals(stringDir)){
                dir = 2;
            }else if("W".equals(stringDir)){
                dir = 3;
            }
            robot.add(new int[] {y,x,dir});
            map[y][x] = i + 1;
        }
        for(int i = 0 ; i < commandCnt ; i++){
//            for(int k = 0 ; k < robot.size() ; k++){
//                System.out.println(Arrays.toString(robot.get(k)));
//            }
            st = new StringTokenizer(br.readLine()," ");
            int num = stoi.apply(st.nextToken()) - 1;
            String command = st.nextToken();
            int cnt = stoi.apply(st.nextToken());
            int[] now = robot.get(num);
            int dir = now[2];
            if("L".equals(command)){
                dir = (dir + cnt * LEFT) % 4;
                now[2] = dir;
            }else if("R".equals(command)){
                dir = (dir + cnt * RIGHT) % 4;
                now[2] = dir;
            }else{
                int ny = now[0];
                int nx = now[1];
                for(int j = 0 ; j < cnt ; j++){
                    ny += dy[dir];
                    nx += dx[dir];
                    if(ny < 0 || ny >= n || nx < 0 || nx >= m){
                        System.out.printf("Robot %d crashes into the wall\n", num+1);
                        return ;
                    }
                    if(map[ny][nx] != 0){
                        System.out.printf("Robot %d crashes into robot %d\n", num+1,map[ny][nx]);
                        return ;
                    }
                }
                map[now[0]][now[1]] = 0;
                map[ny][nx] = num + 1;
                now[0] = ny;
                now[1] = nx;
            }
        }
        System.out.println("OK");
    }
}
