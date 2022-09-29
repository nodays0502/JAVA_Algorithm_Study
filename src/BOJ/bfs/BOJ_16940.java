package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16940 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        Set<Integer>[] set = new HashSet[n+1];
        for(int i = 0 ; i <= n ; i++){
            set[i] = new HashSet<>();
        }
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            set[a].add(b);
            set[b].add(a);
        }
        int[] answer = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            answer[i] = stoi.apply(st.nextToken());
        }
        System.out.println(bfs(answer,n,set));
    }
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    private static int bfs(int[] answer, int n, Set<Integer>[] set) {
        if(answer[0] != 1){
            return FAIL;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] visited = new boolean[n+1];
        int index = 1;
        while(!q.isEmpty()){
            int now = q.poll();
//            System.out.println(now);
            while(index < n && set[now].contains(answer[index]) && !visited[answer[index]]){
                visited[answer[index]] = true;
                q.offer(answer[index]);
                index++;
            }
        }
        if(index != answer.length){
            return FAIL;
        }
        return SUCCESS;
    }
}
