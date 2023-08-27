package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15270 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] friend = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            friend[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            friend[a].add(b);
            friend[b].add(a);
        }
        boolean[] used = new boolean[n+1];
        int result = cal(1,friend,used,n);
        System.out.println(result);
    }

    private static int cal(int depth, List<Integer>[] friend, boolean[] used,int n) {
        if(depth > n){
            int cnt = 0;
            for(int i = 1 ; i <= n ; i++){
                if(used[i]){
                    cnt++;
                }
            }
            if(cnt < n){
                cnt++;
            }
            return cnt;
        }
        int result = 1;
        result = Math.max(result, cal(depth+1,friend,used,n));
        if(used[depth]){
            return result;
        }
        used[depth] = true;
        for(int next : friend[depth]){
            if(used[next]){
                continue;
            }
            used[next] = true;
            result = Math.max(result, cal(depth+1,friend,used,n));
            used[next] = false;
        }
        used[depth] = false;
        return result;
    }
}
