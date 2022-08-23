package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1826 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        List<int[]> list = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int distance = stoi.apply(st.nextToken());
            int fuel = stoi.apply(st.nextToken());
            list.add(new int[] {distance,fuel});
        }
        st = new StringTokenizer(br.readLine());
        int distance = stoi.apply(st.nextToken());
        int fuel = stoi.apply(st.nextToken());
        int result = cal(list,distance,fuel,n);
        System.out.println(result);
    }
    private static final int NOT_FOUND = -1;
    private static int cal(List<int[]> list, int distance, int fuel, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list,(o1,o2)->o1[0]-o2[0]);
        int index = 0;
        int cnt = 0;
        while(true){

            while(index < n && list.get(index)[0] <= fuel){
                pq.offer(list.get(index)[1]);
                index++;
            }
            if(!pq.isEmpty() && fuel < distance){
                fuel += pq.poll();
                cnt++;
            }else{
                break;
            }
        }
        if(fuel >= distance){
            return cnt;
        }
        return NOT_FOUND;
    }
}
