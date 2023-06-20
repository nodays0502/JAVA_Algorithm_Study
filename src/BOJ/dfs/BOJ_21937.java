package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21937 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] map = new List[n+1];
        for(int i = 0 ; i < n+1 ; i++){
            map[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[b].add(a);
        }
        int start = stoi.apply(br.readLine());
        boolean[] visited = new boolean[n+1];
        cal(start,map,visited,n);
        int result = 0;
        for(int i = 1 ; i <= n ; i++){
            if(visited[i] && i != start){
                result++;
            }
        }
        System.out.println(result);
    }

    private static void cal(int start, List<Integer>[] map, boolean[] visited,int n) {
        visited[start] = true;
        for(int next : map[start]){
            if(!visited[next]){
                cal(next,map,visited,n);
            }
        }
        return ;
    }
}
