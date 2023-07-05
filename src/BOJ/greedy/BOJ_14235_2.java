package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14235_2 {
    private static final int NOT_FOUND = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = stoi.apply(st.nextToken());
            if(cnt == 0){
                if(pq.isEmpty()){
                    System.out.println(NOT_FOUND);
                }else{
                    System.out.println(pq.poll());
                }
            }
            for(int j = 0 ; j < cnt ; j++){
                pq.offer(stoi.apply(st.nextToken()));
            }
        }
    }
}
