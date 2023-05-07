package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14567 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] cnt = new int[n+1];
        List<Integer> map[] = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            map[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[a].add(b);
            cnt[b]++;
        }
        int[] result = cal(map,cnt,n);
        for(int i = 1 ; i <= n ; i++){
            System.out.print(result[i]+" ");
        }
    }

    private static int[] cal(List<Integer>[] map, int[] cnt,int n) {
        int[] result = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            if(cnt[i] == 0){
                q.offer(i);
                result[i] = 1;
            }
        }
        int time = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                for(int next : map[now]){
                    if(result[next] == 0){
                        cnt[next]--;
                        if(cnt[next] == 0){
                            result[next] = time + 1;
                            q.offer(next);
                        }
                    }
                }
            }
            time++;
        }
        return result;
    }
}
