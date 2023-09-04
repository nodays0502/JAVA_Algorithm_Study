package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_29160 {
    private static final int SIZE = 11;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        PriorityQueue<Integer>[] pq = new PriorityQueue[SIZE+1];
        for(int i = 0 ; i <= SIZE ; i++){
            pq[i] = new PriorityQueue<>(Collections.reverseOrder());
        }
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int position = stoi.apply(st.nextToken());
            int value = stoi.apply(st.nextToken());
            pq[position].add(value);
        }
        int teamValue = calAfterKYearTeamValue(pq,k);
        System.out.println(teamValue);
    }

    private static int calAfterKYearTeamValue(PriorityQueue<Integer>[] pq, int k) {
        int[] teamValue = new int[SIZE+1];
        for(int i = 0 ; i < k ; i++){
            for(int j = 1 ; j <= SIZE ; j++){ // 3월
                if(!pq[j].isEmpty() && teamValue[j] < pq[j].peek()){
                    pq[j].add(teamValue[j]);
                    teamValue[j] = pq[j].poll();
                }
            }
            for(int j = 1 ; j <= SIZE ; j++){ // 8월
                teamValue[j] = Math.max(teamValue[j]-1,0);
            }
            for(int j = 1 ; j <= SIZE ; j++){ // 11월
                if(!pq[j].isEmpty() && teamValue[j] < pq[j].peek()){
                    pq[j].add(teamValue[j]);
                    teamValue[j] = pq[j].poll();
                }
            }
        }
        int sumTeamValue = 0;
        for(int j = 1 ; j <= SIZE ; j++){
            sumTeamValue += teamValue[j];
        }
        return sumTeamValue;
    }
}
