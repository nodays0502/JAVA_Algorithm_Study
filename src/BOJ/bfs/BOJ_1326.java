package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1326 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int start = stoi.apply(st.nextToken());
        int end = stoi.apply(st.nextToken());
        int result = cal(start,end,input,n);
        System.out.println(result);
    }

    private static int cal(int start, int end, int[] input, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int time = 0;
        Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                if(now == end){
                    return time;
                }
                for(int i = 1 ; now + i * input[now] <= n || now - i * input[now] >= 1; i++){
                    int next = now + i * input[now];
                    if(next <= n && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                    next = now - i * input[now];
                    if(next >= 1 && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
