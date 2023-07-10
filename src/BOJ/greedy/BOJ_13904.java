package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13904 {
    public static class Work{
        int d;
        int w;
        public Work(int d,int w){
            this.d = d;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        List<Work> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int d = stoi.apply(st.nextToken());
            int w = stoi.apply(st.nextToken());
            list.add(new Work(d,w));
        }

        int result = cal(list,n);
        System.out.println(result);
    }

    private static int cal(List<Work> list, int n) {
        Collections.sort(list,(v1,v2)->{
            return v2.d - v1.d ;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        int index = 0;
        for(int day = 1000 ; day > 0  ; day--){
            while(index < n && list.get(index).d >= day){
                pq.offer(list.get(index).w);
                index++;
            }
            if(!pq.isEmpty()){
                result += pq.poll();
            }
        }
        return result;
    }
}
