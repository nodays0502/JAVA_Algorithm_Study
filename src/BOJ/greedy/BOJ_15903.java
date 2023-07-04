package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15903 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] input = new long[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        long result = cal(input,n,m);
        System.out.println(result);
    }

    private static long cal(long[] input, int n, int m) {
        if(n == 1){
            return input[0];
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            pq.offer(input[i]);
        }
        for(int i = 0 ; i < m ; i++){
            long a = pq.poll();
            long b = pq.poll();
            long temp = a + b;
            pq.offer(temp);
            pq.offer(temp);
        }
        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}
