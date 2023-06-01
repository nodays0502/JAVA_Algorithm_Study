package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18235 {
    private static final int NOT_FOUND = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String ,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int a = stoi.apply(st.nextToken());
        int b = stoi.apply(st.nextToken());
        int result = bfs(a,b,n);
        System.out.println(result);
    }

    private static int bfs(int a, int b, int n) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        q.offer(new int[]{a,0});
        q.offer(new int[]{b,1});
        boolean[][][] visited = new boolean[n+1][20][2];
        visited[a][time][0] = true;
        visited[b][time][1] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(now[1] == 0 && visited[now[0]][time][1]) {
                    return time;
                }
                if(now[1] == 1 && visited[now[0]][time][0]) {
                    return time;
                }
                int length = (int)Math.pow(2,time);
                int[] next = new int[]{now[0] + length,now[1]};
                if(check(next,n)){
                    visited[next[0]][time+1][next[1]] = true;
                    q.offer(next);
                }
                next = new int[]{now[0] - length,now[1]};
                if(check(next,n)){
                    visited[next[0]][time+1][next[1]] = true;
                    q.offer(next);
                }
            }
            time++;
        }
        return NOT_FOUND;
    }

    private static boolean check(int[] now, int n) {
        if(now[0] >= 1 && now[0] <= n){
            return true;
        }
        return false;
    }
}
