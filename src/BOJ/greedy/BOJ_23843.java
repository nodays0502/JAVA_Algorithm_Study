package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_23843 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer> input = new ArrayList<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            input.add(stoi.apply(st.nextToken()));
        }
        Collections.sort(input,Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            int num = input.get(i);
            if(pq.size() == m){
                num += pq.poll();
            }
            pq.offer(num);
        }
        while(pq.size() >= 2){
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
