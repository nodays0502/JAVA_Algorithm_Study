package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2637 {

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int m = stoi.apply(br.readLine());
        List<int[]>[] list = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            list[i] = new LinkedList<>();
        }
        int[] cnt = new int[n+1];
        for(int i = 0 ; i < m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = stoi.apply(st.nextToken());
            int y = stoi.apply(st.nextToken());
            int k = stoi.apply(st.nextToken());
            list[x].add(new int[]{y,k});
            cnt[y]++;
        }
        int[] result = cal(list,n,cnt);
        for(int i = 1 ; i <= n ; i++){
            if(list[i].size() == 0){
                System.out.println(i+" "+result[i]);
            }
        }
    }

    private static int[] cal(List<int[]>[] list, int n, int[] cnt) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n,1});
        int[] result = new int[n+1];
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int[] next : list[now[0]]){
                cnt[next[0]]--;
                result[next[0]] += next[1] *now[1];
                if(cnt[next[0]] == 0){
                    q.offer(new int[]{next[0],result[next[0]]});
                }
            }
        }
        return result;
    }
}
