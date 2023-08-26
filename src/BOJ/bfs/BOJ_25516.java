package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_25516 {
    private static final int EMPTY = 0;
    private static final int APPLE = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        List<Integer>[] tree = new List[n];
        for(int i = 0 ; i < n ; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int parent = stoi.apply(st.nextToken());
            int child = stoi.apply(st.nextToken());
            tree[parent].add(child);
        }
        int[] apples = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            apples[i] = stoi.apply(st.nextToken());
        }
        int result = bfs(tree,n,k,apples);
        System.out.println(result);
    }

    private static int bfs(List<Integer>[] tree, int n, int k, int[] apples) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int time = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int now = q.poll();
                if(apples[now] == APPLE){
                    cnt++;
                }
                for(int next : tree[now]){
                    q.offer(next);
                }
            }
            time++;
            if(time > k){
                break;
            }
        }
        return cnt;
    }
}
