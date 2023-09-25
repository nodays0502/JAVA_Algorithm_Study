package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21278 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] list = new List[n+1];
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
        int[] result = cal(list,n);
        for(int i = 0 ; i < 3 ; i++){
            System.out.print(result[i]+" ");
        }
    }
    private static int[] cal(List<Integer>[] list, int n) {
        int[] result = null;
        for(int i = 1 ; i <= n ; i++){
            for(int j = i+1 ; j <= n ; j++){
                int temp = bfs(i,j,list,n);
                if(result == null){
                    result = new int[]{i,j,temp};
                }
                if(result[2] > temp){
                    result = new int[]{i,j,temp};
                }
            }
        }
        return result;
    }

    private static int bfs(int start1,int start2,List<Integer>[] list, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start1);
        q.offer(start2);
        boolean[] visited = new boolean[n+1];
        visited[start1] = true;
        visited[start2] = true;
        int time = 0;
        int result = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                result += time;
                for(int next : list[now]){
                    if(!visited[next]){
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
            time++;
        }
        return 2*result;
    }
}
