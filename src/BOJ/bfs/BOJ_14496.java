package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14496 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int a = stoi.apply(st.nextToken());
        int b = stoi.apply(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] list = new LinkedList[n+1];
        for(int i = 0 ; i <= n ; i++){
            list[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int start = stoi.apply(st.nextToken());
            int end = stoi.apply(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        int result = bfs(list,a,b,n);
        System.out.println(result);
    }
    private static final int NOT_FOUND = -1;
    private static int bfs(List<Integer>[] list, int a, int b, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        boolean[] visited = new boolean[n+1];
        int time = 0;
        visited[a] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
//                System.out.println(time+" "+now);
                if(now == b){
                    return time;
                }
                for(int next : list[now]){
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }

            }
            time++;
        }
        return NOT_FOUND;
    }
}
