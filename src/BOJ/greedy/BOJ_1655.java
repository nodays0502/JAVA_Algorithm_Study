package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] number = new int[n];
        for(int i = 0 ; i < n ; i++){
            number[i] = Integer.parseInt(br.readLine());
        }
        String result = cal(number,n);
        System.out.println(result);
    }

    private static String cal(int[] number, int n) {
        PriorityQueue<Integer> max = new PriorityQueue<>();
        PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            if(min.isEmpty()){
                min.add(number[i]);
                sb.append(min.peek()+"\n");
                continue;
            }
            if(min.peek() < number[i]){
                max.add(number[i]);
            }else{
                min.add(number[i]);
            }
            if(min.size() + 1 > max.size()){
                max.add(min.poll());
            }
            if(min.size() < max.size()){
                min.add(max.poll());
            }
            sb.append(min.peek()+"\n");
        }
        return sb.toString();
    }
}
