package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10917 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] list = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            list[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            list[a].add(b);
        }
        int result = bfs(list,n);
        System.out.println(result);
    }
    private static final int START = 1;
    private static final int NOT_FOUND = -1;
    private static int bfs(List<Integer>[] list, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(START);
        boolean[] visited = new boolean[n+1];
        visited[START] = true;
        int time = 0;
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int s = 0 ; s < qSize ; s++){
                int now = q.poll();
                if(now == n){
                    return time;
                }
                for(int next : list[now]){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next] = true;
                    }
                }
            }
            time++;
        }
        return NOT_FOUND;
    }
}
