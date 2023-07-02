package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1202 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        List<int[]> input = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int m = stoi.apply(st.nextToken());
            int v = stoi.apply(st.nextToken());
            input.add(new int[]{m,v});
        }
        int[] bag = new int[k];
        for(int i = 0 ; i < k ; i++){
            bag[i] = stoi.apply(br.readLine());
        }
        Collections.sort(input,(v1,v2)->{
            return v1[0] - v2[0];
        });
        Arrays.sort(bag);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int index = 0;
        for(int i = 0 ; i < k ; i++){
            while(index < n && input.get(index)[0] <= bag[i]){
                pq.offer(input.get(index)[1]);
                index++;
            }
            if(!pq.isEmpty()){
                sum += pq.poll();
            }
        }
        System.out.println(sum);
    }
}
