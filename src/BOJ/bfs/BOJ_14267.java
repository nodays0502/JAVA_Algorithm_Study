package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14267 {
    private static final int NO_SENIOR = -1;
    private static final int CEO = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] list = new List[n+1];
        for(int i = 1 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1 ; i <= n ; i++){
            int parent = stoi.apply(st.nextToken());
            if(parent == NO_SENIOR){
                continue;
            }
            list[parent].add(i);
        }
        int[] scores = new int[n+1];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int employeeNo = stoi.apply(st.nextToken());
            int weight = stoi.apply(st.nextToken());
            scores[employeeNo] += weight;
        }
        bfs(list,scores,n);
        for(int i = 1 ; i <= n ; i++){
            System.out.print(scores[i]+" ");
        }
    }

    private static void bfs(List<Integer>[] list, int[] scores, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {CEO,scores[CEO]});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int next : list[now[0]]){
                scores[next] += now[1];
                q.offer(new int[] {next,scores[next]});
            }
        }
    }
}
