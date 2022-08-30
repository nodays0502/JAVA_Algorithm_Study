package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_12886 {
    private static final int SIZE = 3;
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int[] num = new int[SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            num[i] = stoi.apply(st.nextToken());
        }
        int result = bfs(num);
        System.out.println(result);
    }
    private static int bfs(int[] num) {
        Queue<int[]> q = new LinkedList<>();
        Arrays.sort(num);
        q.offer(num);
        Set<String> visited = new HashSet<>();
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == now[1] && now[1] == now[2]){
                return SUCCESS;
            }
            for(int i = 0 ; i < 3 ; i++){
                int[] next = Arrays.copyOf(now,now.length);
                int j = (i + 1) % 3;
                int min = Math.min(next[i],next[j]);
                int max = Math.max(next[i],next[j]);
                if(max == min){
                    continue;
                }
                next[i] = max - min;
                next[j] = 2 * min;
                Arrays.sort(next);
                if(!visited.contains(Arrays.toString(next))){
                    visited.add(Arrays.toString(next));
                    q.offer(next);
                }
            }

        }
        return FAIL;

    }
}
