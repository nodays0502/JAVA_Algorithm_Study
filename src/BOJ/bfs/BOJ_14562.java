package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14562 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int s = stoi.apply(st.nextToken());
            int t = stoi.apply(st.nextToken());
            int result = bfs(s,t);
            System.out.println(result);
        }
    }
    private static final int NOT_FOUND = -1;
    private static int bfs(int start,int end) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start,end});
        Set<String> visited = new HashSet<>();
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                if(now[0] == now[1]){
                    return time;
                }
                int[] next = new int[] {now[0]+1,now[1]};
                if(next[0] <= next[1] && !visited.contains(Arrays.toString(next))){
                    visited.add(Arrays.toString(next));
                    q.offer(next);
                }
                next = new int[] {2*now[0],now[1]+3};
                if(next[0] <= next[1] && !visited.contains(Arrays.toString(next))){
                    visited.add(Arrays.toString(next));
                    q.offer(next);
                }
            }
            time++;
        }
        return NOT_FOUND;
    }
}
