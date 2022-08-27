package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_23757 {
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            int num = stoi.apply(st.nextToken());
            pq.offer(num);
        }
        st = new StringTokenizer(br.readLine());
        int flag = SUCCESS;
        for(int i = 0 ; i < m ; i++){
            int num = stoi.apply(st.nextToken());
            if(pq.peek() >= num){
                pq.offer(pq.poll() - num);
            }else{
                flag = FAIL;
                break;
            }
        }
        System.out.println(flag);
    }
}
