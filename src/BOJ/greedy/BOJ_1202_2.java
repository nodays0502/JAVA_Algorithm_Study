package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<int[]> jewelry = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int m =  Integer.parseInt(st.nextToken());
            int v =  Integer.parseInt(st.nextToken());
            jewelry.add(new int[]{m,v});
        }
        int[] bag = new int[k];
        for(int i = 0 ; i < k ; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }
        long result = cal(bag,jewelry,n,k);
        System.out.println(result);
    }

    private static long cal(int[] bag, List<int[]> jewelry, int n, int k) {
        jewelry.sort((v1,v2)->{
            return v1[0] - v2[0];
        });
        Arrays.sort(bag);
        int index = 0;
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < k ; i++){
            while(index < n && jewelry.get(index)[0] <= bag[i]){
                pq.offer(jewelry.get(index)[1]);
                index++;
            }
            if(!pq.isEmpty()){
                sum += pq.poll();
            }
        }
        return sum;
    }

}
