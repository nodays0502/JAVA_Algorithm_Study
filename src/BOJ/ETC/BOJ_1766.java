package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1766 {
    private static String cal(List<Integer>[] map,int n,int[] count){
        Queue<Integer> q = new PriorityQueue<>();
        for(int i = 1 ; i <= n ; i++){
            if(count[i] == 0){
                q.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now+" ");
            for(int i = 0 ; i < map[now].size(); i++){
                int next = map[now].get(i);
                if(--count[next] == 0){
                    q.offer(next);
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] map = new List[n+1];
        for(int i = 1 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        int[] count = new int[n+1];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            map[a].add(b);
            count[b]++;
        }
        System.out.println(cal(map,n,count));
    }
}
