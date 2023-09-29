package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_24479 {
    private static int NUMBER = 1;
    private static final int NOT_VISITED = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int start = stoi.apply(st.nextToken());
        List<Integer> list[] = new List[n+1];
        for(int i = 1 ; i <= n ; i++){
            list[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for(int i = 1 ; i <= n ; i++){
            Collections.sort(list[i]);
        }
        int[] arrived = new int[n+1];
        dfs(start,list,arrived);
        for(int i = 1 ; i <= n ; i++){
            System.out.println(arrived[i]);
        }
    }

    private static void dfs(int now, List<Integer>[] list, int[] arrived) {
        arrived[now] = NUMBER++;
        for(int next : list[now]){
            if(arrived[next] == NOT_VISITED){
                dfs(next,list,arrived);
            }
        }
    }
}
