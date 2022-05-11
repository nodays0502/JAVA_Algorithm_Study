package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Function;

public class BOJ_1655 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        Queue<Integer> minQ = new PriorityQueue<>((o1,o2) ->{
            return o2 - o1;
        }); // 작은 것 중에 가장 큰 값
        Queue<Integer> maxQ = new PriorityQueue<>((o1,o2)->{
            return o1 - o2;
        }); // 큰 것들 중에 가장 작은 값
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            int num = stoi.apply(br.readLine());
            if(minQ.isEmpty() || minQ.peek() > num){
                minQ.offer(num);
            } else {
                maxQ.offer(num);
            }
            if(minQ.size() - maxQ.size() > 1){
                maxQ.offer(minQ.poll());
            }
            if(maxQ.size() - minQ.size() >= 1){
                minQ.offer(maxQ.poll());
            }
//            System.out.println("minQ:"+minQ);
//            System.out.println("maxQ:"+maxQ);
            sb.append(minQ.peek()+"\n");
        }
        System.out.println(sb.toString());
    }
}
