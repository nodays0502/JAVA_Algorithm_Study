package BOJ.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16437_2 {
    private static class Node{
        int number;
        long cnt;

        public Node(int number, long cnt) {
            this.number = number;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n  = stoi.apply(st.nextToken());
        int[] weight = new int[n+1];
        List<Integer>[] list = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 2 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            char type = st.nextToken().charAt(0);
            int cnt  = stoi.apply(st.nextToken());
            int parent  = stoi.apply(st.nextToken());
            list[parent].add(i);
            if(type == 'S'){
                weight[i] = cnt;
            }else {
                weight[i] = -cnt;
            }
        }
        long result = dfs(1,weight,list);
        System.out.println(result);
    }

    private static long dfs(int now, int[] weight, List<Integer>[] list) {
        long result = 0;
//        System.out.println(now);
        for(int next : list[now]){
            result += dfs(next,weight,list);
        }
        if(weight[now] >= 0){
            return result + weight[now];
        }
        if(weight[now] < 0 && result + weight[now] > 0){
            return result +weight[now];
        }
        return 0;
    }

    private static long bfs(int[] wolf, Queue<Node> q, int n, int[] path) {
        long result = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
//            System.out.println(now.number +" "+now.cnt);
            if(now.number == 1){
                result += now.cnt;
                continue;
            }
            long min = Math.min(now.cnt,wolf[now.number]);
            long cnt = now.cnt - min;
            wolf[now.number] -= min;
            if(cnt > 0){
                q.offer(new Node(path[now.number],cnt));
            }
        }
        return result;
    }
}
