package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17503 {
    static class Beer{
        int value;
        int limit;

        public Beer(int value, int limit) {
            this.value = value;
            this.limit = limit;
        }

        @Override
        public String toString() {
            return "Beer{" +
                "value=" + value +
                ", limit=" + limit +
                '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        Beer[] beers = new Beer[k];
        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine());
            int value = stoi.apply(st.nextToken());
            int limit = stoi.apply(st.nextToken());
            beers[i] = new Beer(value,limit);
        }
        Arrays.sort(beers,(o1,o2)->{
            if(o1.limit == o2.limit){
                return o2.value - o1.value;
            }
            return o1.limit - o2.limit;
        });
//        System.out.println(Arrays.toString(beers));
        PriorityQueue<Beer> pq = new PriorityQueue<>((o1,o2)->{
            return o1.value - o2.value;
        });
        long value = 0;
        long limit = 0;
        int index = 0;
        for( ; index < Math.min(n,k) ; index++){
            pq.offer(beers[index]);
            value += beers[index].value;
            limit = Math.max(limit, beers[index].limit);

//            System.out.println(index+" "+value);
        }
        if(value >= m){
            System.out.println(limit);
            return;
        }
        while(index < k){
            Beer temp = pq.poll();
            value -= temp.value;
            pq.offer(beers[index]);
            value += beers[index].value;
            limit = Math.max(limit, beers[index].limit);

//            System.out.println(index+" "+value);
            index++;
            if(value >= m){
                System.out.println(limit);
                return;
            }
        }
        System.out.println(-1);
    }
}
