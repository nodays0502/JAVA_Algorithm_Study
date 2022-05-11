package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1516 {
    private static class Node{
        int time;
        int number;

        public Node(int time, int number) {
            this.time = time;
            this.number = number;
        }
    }
    static final int INF = 100_000 * 500;
    private static String cal(List<Integer>[] map,int[] needTime,int[] count,int n){
        StringBuilder result = new StringBuilder();
        int[] startTime = new int[n+1];
        Arrays.fill(startTime,0);
        Queue<Node> q = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            if(count[i] == 0){
                q.offer(new Node(0,i));
                startTime[i] = 0;
            }
        }
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i = 0 ; i < map[now.number].size(); i++){
                int next = map[now.number].get(i);
                startTime[next] = Math.max(startTime[next],now.time + needTime[now.number]);
                if(--count[next] == 0){
                    q.offer(new Node(startTime[next],next));
                }
            }
        }
        for(int i = 1 ; i <= n ; i++){
            result.append(startTime[i]+needTime[i]+"\n");
        }
        return result.toString();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        List<Integer>[] map = new ArrayList[n+1];
        int[] needTime = new int[n+1];
        int[] count = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int weight = stoi.apply(st.nextToken());
            int num = stoi.apply(st.nextToken());
            needTime[i] = weight;
            while(num != -1){
                map[num].add(i);
                count[i]++;
                num = stoi.apply(st.nextToken());
            }
        }
        System.out.println(cal(map,needTime,count,n));
    }
}
