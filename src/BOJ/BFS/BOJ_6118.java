package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_6118 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] map = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        int[] result = bfs(map,n);
        for(int num : result){
            System.out.print(num+" ");
        }
    }
    private static int INF = 987654321;
    private static int[] bfs(List<Integer>[] map, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        int time = -1;
        int cnt = 0;
        int resultNum = INF;
        while(!q.isEmpty()){
            int size = q.size();
            resultNum = INF;
            cnt = size;
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                resultNum = Math.min(now,resultNum);
                for(int next : map[now]){
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            time++;
        }
        return new int[] {resultNum,time,cnt};
    }
}
