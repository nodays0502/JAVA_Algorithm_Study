package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1781 {
    private static class Problem{
        int deadLine;
        int reward;

        public Problem(int deadLine, int reward) {
            this.deadLine = deadLine;
            this.reward = reward;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," " );
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        List<Problem> input = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," " );
            int deadLine = stoi.apply(st.nextToken());
            int reward = stoi.apply(st.nextToken());
            input.add(new Problem(deadLine,reward));
        }
        Collections.sort(input,(o1,o2)->{
            if(o1.deadLine == o2.deadLine){
                return o2.reward - o1.reward;
            }
            return o2.deadLine - o1.deadLine;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;
        int result = 0;
        for(int deadLine = n ; deadLine >= 1 ; deadLine--){
            while(index < input.size()){
                Problem problem = input.get(index);
//                System.out.println(problem.deadLine+" "+problem.reward);
                if(problem.deadLine >= deadLine){
                    pq.offer(problem.reward);
                    index++;
                }else{
                    break;
                }
            }
            if(!pq.isEmpty()){
                result += pq.poll();
//                System.out.println(deadLine+" "+result);
            }
        }
        System.out.println(result);
    }
}
