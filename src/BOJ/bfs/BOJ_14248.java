package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14248 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        int start = stoi.apply(br.readLine()) - 1;
        int result = bfs(start,n,input);
        System.out.println(result);
    }

    private static int bfs(int start, int n, int[] input) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(start);
        visited[start] = true;
        int result = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = -1 ; i <= 1 ; i++){
                if(i == 0){
                    continue;
                }
                int next = now + i * input[now];
                if(checkBound(next,n) && !visited[next]){
                    result++;
                    visited[next]  = true;
                    q.offer(next);
                }
            }
        }
        return result;
    }
    private static boolean checkBound(int now, int n){
        if(now >= 0 && now < n){
            return true;
        }
        return false;
    }
}
