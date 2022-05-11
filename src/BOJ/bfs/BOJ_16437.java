package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16437 {
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
        int[] path = new int[n+1];
        int[] wolf = new int[n+1];
        Queue<Node> q = new LinkedList<>();
        for(int i = 2 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            char type = st.nextToken().charAt(0);
            int cnt  = stoi.apply(st.nextToken());
            int next  = stoi.apply(st.nextToken());
            path[i] = next;
            if(type == 'S'){
                q.offer(new Node(i,cnt));
            }else {
                wolf[i] = cnt;
            }
        }
        long result = bfs(wolf,q,n,path);
        System.out.println(result);
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
