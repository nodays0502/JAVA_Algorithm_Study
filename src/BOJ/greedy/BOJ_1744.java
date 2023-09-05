package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.function.Function;

public class BOJ_1744 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = stoi.apply(br.readLine());
        }
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            if(arr[i] <= 0){
                minus.add(arr[i]);
            }else{
                plus.add(arr[i]);
            }
        }
        int result = 0;
        result += countMultiplySum(plus);
        result += countMultiplySum(minus);
        System.out.println(result);
    }

    private static int countMultiplySum(PriorityQueue<Integer> pq) {
        int sum = 0;
        while(pq.size() >= 2){
            int num1 = pq.poll();
            int num2 = pq.poll();
            if(num2 == 1){
                sum += num1 + num2;
                continue;
            }
            sum += num1 * num2;
        }
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;
    }
}
