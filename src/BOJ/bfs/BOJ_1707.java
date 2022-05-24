package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1707 {
    private static int EMPTY = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0 ; t < test ;t++){
            st = new StringTokenizer(br.readLine()," ");
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            List<Integer>[] list = new List[n+1];
            for(int i = 1 ; i <= n ; i++){
                list[i] = new ArrayList<>();
            }
            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = stoi.apply(st.nextToken());
                int b = stoi.apply(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            if(canDivided(list,n)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean canDivided(List<Integer>[] list, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[n+1];
//        q.offer(1);
//        color[1] = 1;
        while(true){
            if(q.isEmpty()){
                boolean flag = false;
                for(int i = 1; i <= n ; i++){
                    if(color[i] == EMPTY){
                        flag = true;
                        q.offer(i);
                        color[i] = 1;
                        break;
                    }
                }
                if(!flag){
                    break;
                }
            }
            int now = q.poll();
            for(int next : list[now]){
                if(color[next] == EMPTY && color[now] == 1){
                    color[next] = 2;
                    q.offer(next);
                    continue;
                }
                if(color[next] == EMPTY && color[now] == 2){
                    color[next] = 1;
                    q.offer(next);
                    continue;
                }
                if(color[now] == color[next]){
                    return false;
                }
            }
        }
        return true;
    }
}
