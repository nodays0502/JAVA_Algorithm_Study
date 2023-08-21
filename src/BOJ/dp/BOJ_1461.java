package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1461 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] positions = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            positions[i] = stoi.apply(st.nextToken());
        }
        int result = cal(positions,n,m);
        System.out.println(result);
    }

    private static int cal(int[] positions, int n, int m) {
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        for(int position : positions){
            if(position > 0){
                positive.add(position);
            }else{
                negative.add(position);
            }
        }
        positive.add(0);
        negative.add(0);
        int max = Math.max(Math.abs(positive.peek()),Math.abs(negative.peek()));
        int result = 0;
        while(!positive.isEmpty()){
            result += 2 * Math.abs(positive.poll());
            for(int i = 0 ; i < m - 1 ; i++){
                if(!positive.isEmpty()){
                    positive.poll();
                }
            }

        }
        while(!negative.isEmpty()){
            result += 2 * Math.abs(negative.poll());
            for(int i = 0 ; i < m - 1 ; i++){
                if(!negative.isEmpty()){
                    negative.poll();
                }
            }
        }
        result -= max;
        return result;
    }
}
