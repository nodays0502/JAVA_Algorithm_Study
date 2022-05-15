package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.function.Function;

public class BOJ_1417 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int voteCnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                voteCnt = stoi.apply(br.readLine());
            }else{
                int num = stoi.apply(br.readLine());
                pq.offer(num);
            }
        }
        int result = 0;
        while(!pq.isEmpty()){
            if(voteCnt <= pq.peek()){
                result++;
                voteCnt++;
                pq.offer(pq.poll() -1);
            }else{
                break;
            }
        }
        System.out.println(result);
    }
}
