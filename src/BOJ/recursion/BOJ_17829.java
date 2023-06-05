package BOJ.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17829 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int[][] input = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                input[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = cal(0,0,input,n,n);
        System.out.println(result);
    }

    private static int cal(int y, int x, int[][] input, int length, int n) {
        if(length == 1){
            return input[y][x];
        }
        int nextLength = length / 2;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                pq.offer(cal(y+nextLength*i,x+nextLength*j,input,nextLength,n));
            }
        }
        pq.poll();
        return pq.poll();
    }
}
