package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18232 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s = stoi.apply(st.nextToken());
        int e = stoi.apply(st.nextToken());
        List<Integer>[] teleport = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            teleport[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            teleport[a].add(b);
            teleport[b].add(a);
        }
        int result = bfs(s,e,n,teleport);
        System.out.println(result);
    }

    private static int bfs(int s, int e, int n, List<Integer>[] teleport) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int time = 0;
        boolean[] visited = new boolean[n+1];
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int now = q.poll();
                if(now == e){
                    return time;
                }
                for(int j = -1 ; j <= 1; j++){
                    int next = now + j;
                    if(next >= 0 && next <= n && !visited[next]){
                        q.offer(next);
                        visited[next] = true;
                    }
                }
                for(int next : teleport[now]){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
