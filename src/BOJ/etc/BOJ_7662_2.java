package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;

public class BOJ_7662_2 {
    private static final String EMPTY = "EMPTY";
    private static void offer(Map<Long, Integer> map, PriorityQueue<Long> maxQ, PriorityQueue<Long> minQ,
        long num) {
        maxQ.offer(num);
        minQ.offer(num);
        map.put(num,map.getOrDefault(num,0)+1);
    }

    private static String poll(Map<Long, Integer> map, PriorityQueue<Long> q) {
        while (!q.isEmpty()) {
            long temp = q.poll();
            int cnt = map.getOrDefault(temp,0);
            if (cnt == 0) {
                continue;
            }
            map.put(temp, cnt - 1);
            return Long.toString(temp);
        }
        return EMPTY;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        Function<String, Long> stol = Long::parseLong;
        int test = stoi.apply(br.readLine());
        for (int t = 0; t < test; t++) {
            int n = stoi.apply(br.readLine());
            PriorityQueue<Long> maxQ = new PriorityQueue<>((o1, o2) -> {
                if(o2 > o1){
                    return 1;
                }else if(o2 == o1){
                    return 0;
                }else{
                    return -1;
                }
            });
            PriorityQueue<Long> minQ = new PriorityQueue<>();
            Map<Long, Integer> numCnt = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String command = br.readLine();
                String[] temp = command.split(" ");
                long num = stol.apply(temp[1]);
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
