package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_19538 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        Set<Integer>[] friend = new HashSet[n+1];
        for(int i = 1; i <= n ; i++){
            friend[i]  = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int num = stoi.apply(st.nextToken());
            while(num != 0){
                friend[i].add(num);
                num = stoi.apply(st.nextToken());
            }
        }
        int cnt = stoi.apply(br.readLine());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        for(int i = 0 ; i < cnt ; i++){
            int num = stoi.apply(st.nextToken());
            q.offer(num);
            visited[num] = true;
        }
        bfs(q,friend,n,visited);
    }

    private static void bfs(Queue<Integer> q,Set<Integer>[] friend, int n ,boolean[] visited) {
        int[] result = new int[n+1];
        int[] cnt = new int[n+1];
        Arrays.fill(result,-1);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                visited[now] = true;
                result[now] = time;
                for(int next : friend[now]){
                    cnt[next]++;
                    if(!visited[next] && cnt[next] >= (friend[next].size() +1) /2){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            time++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++){
            sb.append(result[i]+" ");
        }
        System.out.println(sb);
    }
}
