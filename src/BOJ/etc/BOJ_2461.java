package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2461 {
    private static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] input = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                input[i][j] = stoi.apply(st.nextToken());
            }
            Arrays.sort(input[i]);
        }
        int result = MAX;
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1,v2)->{
            return v1[0] - v2[0];
        });
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            pq.offer(new int[]{input[i][0],i,0});
            max = Math.max(input[i][0],max);
        }
        while(true){
            result = Math.min(max-pq.peek()[0],result);
            int[] now = pq.poll();
            int i = now[1];
            int j = now[2];
            j++;
            if(j >= m){
                break;
            }
            int value = input[i][j];
            pq.offer(new int[]{value,i,j});
            max = Math.max(max,value);
        }
        System.out.println(result);
    }
}
