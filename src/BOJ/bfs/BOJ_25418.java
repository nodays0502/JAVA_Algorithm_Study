package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_25418 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int start = stoi.apply(st.nextToken());
        int end = stoi.apply(st.nextToken());
        int result = bfs(start,end);
        System.out.println(result);
    }

    private static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int num = q.poll();
                if(num == end){
                    return time;
                }
                int next = num+1;
                if(!visited.contains(next)){
                    q.offer(next);
                    visited.add(next);
                }
                next = 2 * num;
                if(next > 2_000_000){
                    continue;
                }
                if(!visited.contains(next)){
                    q.offer(next);
                    visited.add(next);
                }
            }
            time++;
        }
        return -1;
    }
}
