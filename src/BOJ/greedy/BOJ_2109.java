package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2109 {
    static class Class{
        int price;
        int duration;

        public Class(int price, int duration) {
            this.price = price;
            this.duration = duration;
        }
    }
    private static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        Class[] classes = new Class[n];
        int maxDuration = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int price = stoi.apply(st.nextToken());
            int duration = stoi.apply(st.nextToken());
            maxDuration = Math.max(duration,maxDuration);
            classes[i] = new Class(price,duration);
        }
        Arrays.sort(classes,(o1,o2)->{ // 내림차순 정렬
            return o2.duration - o1.duration;
        });
        PriorityQueue<Class> pq = new PriorityQueue<>((o1,o2)->{ // 내림차순 정렬
            return o2.price - o1.price;
        });
        int index = 0;
        int result = 0;
        for(int time = maxDuration ; time >= 1 ; time--){
            while(index < n && classes[index].duration == time){
                pq.offer(classes[index++]);
            }
            if(!pq.isEmpty()){
                result += pq.poll().price;
            }
        }
        System.out.println(result);
    }
}
