package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_23741 {
    private static final int NOT_FOUND = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int x = stoi.apply(st.nextToken());
        int y = stoi.apply(st.nextToken());
        List<Integer>[] list = new List[n+1];
        for(int i = 1 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int start = stoi.apply(st.nextToken());
            int end = stoi.apply(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        List<Integer> result = bfs(n,list,x,y);
        if(result.size() == 0){
            System.out.println(NOT_FOUND);
        }else{
            for(int num : result){
                System.out.print(num+" ");
            }
        }
    }

    private static List bfs(int n, List<Integer>[] list,int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        int time = 0;
        List<Integer> result = new LinkedList<>();
        while(!q.isEmpty()){
            if(time == y){
                while(!q.isEmpty()){
                    result.add(q.poll());
                }
                break;
            }
            int size = q.size();
            boolean[] visited = new boolean[n+1];
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
//                System.out.println(time+" "+now);
                for(int next : list[now]){
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            time++;
        }
        Collections.sort(result);
        return result;
    }
}
