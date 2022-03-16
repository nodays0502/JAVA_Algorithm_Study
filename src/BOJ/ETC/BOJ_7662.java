package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_7662 {
    private static final String EMPTY = "EMPTY";
    private static void offer(Map<Integer, Integer> map, PriorityQueue<Integer> maxQ, PriorityQueue<Integer> minQ,
        int num) {
        maxQ.offer(num);
        minQ.offer(num);
        map.put(num,map.getOrDefault(num,0)+1);
    }

    private static String poll(Map<Integer, Integer> map, PriorityQueue<Integer> q) {
        while (!q.isEmpty()) {
            int temp = q.poll();
            int cnt = map.getOrDefault(temp,0);
            if (cnt == 0) {
                continue;
            }
            map.put(temp, cnt - 1);
            return Integer.toString(temp);
        }
        return EMPTY;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        int test = stoi.apply(br.readLine());
        for (int t = 0; t < test; t++) {
            int n = stoi.apply(br.readLine());
//            PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> {
//                return o2 - o1;
//            });
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            Map<Integer, Integer> numCnt = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String command = br.readLine();
                String[] temp = command.split(" ");
                int num = stoi.apply(temp[1]);
                if ("I".equals(temp[0])) { // I num
                    offer(numCnt,maxQ,minQ,num);
                } else {
                    if(num == 1){ // D 1
                        poll(numCnt,maxQ);
                    }else{ // D -1
                        poll(numCnt,minQ);
                    }
                }
            }
            String max = poll(numCnt,maxQ);
            if(EMPTY.equals(max)){
                System.out.println(EMPTY);
            }else{
                String min = poll(numCnt,minQ);
                if(EMPTY.equals(min)){
                    System.out.println(max+" "+max);
                }else{
                    System.out.println(max+" "+min);
                }
            }
        }
    }
}
