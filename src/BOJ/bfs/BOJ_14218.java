package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14218 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] list =  new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            list[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        int q= stoi.apply(br.readLine());
        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
//            Map<Integer,Integer> isConnected = new HashMap<>();
//            isConnected.put(a,b);
//            isConnected.put(b,a);
            list[a].add(b);
            list[b].add(a);
            int[] result = bfs(list,n);
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= n ; j++){
                sb.append(result[j]+" ");
            }
            sb.setLength(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
    private static final int NOT_VALID = -1;
    private static int[] bfs(List<Integer>[] list, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[]visited = new boolean[n+1];
        visited[1] = true;
        int[] result = new int[n+1];
        Arrays.fill(result,NOT_VALID);
        int time = 0;
        while(!q.isEmpty()){
            int size  = q.size();
            for(int s = 0; s < size ; s++){
                int now = q.poll();
                result[now] = time;
                for(int next : list[now]){
                    if(!visited[next]){
                        q.offer(next);
                        visited[next] = true;
                    }
                }
//                if(isConnected.containsKey(now) ){
//                    int next = isConnected.get(now);
//                    if(!visited[next]){
//                        q.offer(next);
//                        visited[next] = true;
//                    }
//                }
            }
            time++;
        }
        return result;
    }
}
