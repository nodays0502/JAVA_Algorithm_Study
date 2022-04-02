package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15903 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        PriorityQueue<Long> q = new PriorityQueue();
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            long num = stoi.apply(st.nextToken());
            q.offer(num);
        }
        for(int i = 0 ; i < m ; i++){
            long a = q.poll();
            long b = q.poll();
            long num = a+b;
            q.offer(num);
            q.offer(num);
        }
        long result = 0;
        while(!q.isEmpty()){
            result += q.poll();
        }
        System.out.println(result);
    }
}
