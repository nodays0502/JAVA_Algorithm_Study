package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2014 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        Function<String,Long> stol = Long::parseLong;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        long[] number = new long[n];
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            number[i] = stol.apply(st.nextToken());
            pq.offer(number[i]);
        }
        long temp = 0;
        for(int i = 0 ; i < k ; i++){
            temp = pq.poll();
            for(int j = 0 ; j < n ; j++){
                long value = temp * number[j];
                pq.offer(value);
                if(temp % number[j] == 0){
                    break;
                }
            }
        }
        System.out.println(temp);
    }
}
