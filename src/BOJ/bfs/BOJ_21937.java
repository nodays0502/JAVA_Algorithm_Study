package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21937 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] list = new LinkedList[n+1];
        for(int i = 0 ; i <= n ; i++){
            list[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            list[b].add(a);
        }
        int start = stoi.apply(br.readLine());
        int result = bfs(list,n,start);
        System.out.println(result);
    }

    private static int bfs(List<Integer>[] list, int n,int start) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int result = 0;
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list[now]){
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                    result++;
                }
            }
        }
        return result;
    }
}
