package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;

public class BOJ_1715 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){
            int num = stoi.apply(br.readLine());
            q.offer(num);
        }
        long result = 0;
        while(q.size() > 1){
            int num1 = q.poll();
            int num2 = q.poll();
            q.offer(num1 + num2);
            result += (num1+num2);
        }
        System.out.println(result);
    }
}
