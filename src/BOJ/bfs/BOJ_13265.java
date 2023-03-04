package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13265 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int testCnt = stoi.apply(st.nextToken());
        for(int t = 0 ; t < testCnt ; t++){
            st = new StringTokenizer(br.readLine());
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            List<Integer>[] map = new LinkedList[n+1];
            for(int i = 0 ; i <= n ; i++){
                map[i] = new LinkedList<>();
            }
            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int a = stoi.apply(st.nextToken());
                int b = stoi.apply(st.nextToken());
                map[a].add(b);
                map[b].add(a);
            }
            cal(map,n);
        }
    }

    private final static String POSSIBLE = "possible";
    private final static String IMPOSSIBLE = "impossible";

    private static void cal(List<Integer>[] map,int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] color = new int[n+1];
        visited[1] = true;
        color[1] = 1;
        q.offer(1);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                for(int next : map[now]){
                    if(!visited[next]){
                        q.offer(next);
                        color[next] = time % 2;
                        visited[next] = true;
                    }else if(color[next] == color[now]){
                        System.out.println(IMPOSSIBLE);
                        return;
                    }
                }
            }
            if(q.isEmpty()){
                for(int i = 1 ; i <= n ; i++){
                    if(!visited[i]){
                        q.offer(i);
                        visited[i] = true;
                        color[i] = time % 2;
                        break;
                    }
                }
            }
            time++;
        }
        System.out.println(POSSIBLE);
    }
}
