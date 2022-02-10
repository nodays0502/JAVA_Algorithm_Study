package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13904 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        List<Integer>[] list = new List[1_000+1];
        for(int i = 1 ; i <= 1_000 ; i++){
            list[i] = new ArrayList<>();
        }
        int maxDue = 0;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int due = stoi.apply(st.nextToken());
            int score = stoi.apply(st.nextToken());
            list[due].add(score);
            maxDue = Math.max(maxDue,due);
        }
        int result = 0;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = maxDue ; i >= 1 ; i--){
            for(int j = 0 ; j < list[i].size() ; j++){
                q.offer(list[i].get(j));
            }
            if(!q.isEmpty()){
                result += q.poll();
            }
        }
        System.out.println(result);
    }
}
