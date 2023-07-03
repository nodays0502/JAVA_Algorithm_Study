package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1766 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] cnt = new int[n+1];
        List<Integer>[] nextWork = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            nextWork[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int prevWork = stoi.apply(st.nextToken());
            int work = stoi.apply(st.nextToken());
            cnt[work]++;
            nextWork[prevWork].add(work);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1 ; i <= n ; i++){
            if(cnt[i] == 0){
                pq.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now+" ");
            for(int next : nextWork[now]){
                if(--cnt[next] == 0) {
                    pq.offer(next);
                }
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());
    }
}
