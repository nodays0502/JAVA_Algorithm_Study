package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_12761 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = cal(n,m,a,b);
        System.out.println(result);
    }

    private static final int LIMIT = 100_000;
    private static int cal(int start, int target, int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int time = 0;
        int[] length = new int[]{1,a,b};
        Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                if(now == target){
                    return time;
                }
                for(int i = 0 ; i < length.length ; i++){
                    int next = now + length[i];
                    if(next >= 0 && next <= LIMIT && !visited.contains(next)){
                        visited.add(next);
                        q.offer(next);
                    }
                    next = now - length[i];
                    if(next >= 0 && next <= LIMIT && !visited.contains(next)){
                        visited.add(next);
                        q.offer(next);
                    }
                    if(i == 0){
                        continue;
                    }
                    next = now * length[i];
                    if(next >= 0 && next <= LIMIT && !visited.contains(next)){
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
