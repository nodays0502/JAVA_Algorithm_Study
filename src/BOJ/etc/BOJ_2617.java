package BOJ.etc;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.Queue;
    import java.util.StringTokenizer;
    import java.util.function.Function;

public class BOJ_2617 {
    private static int bfs(List<Integer>[] list, int n, int start){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(start);
        int result = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : list[now]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    result++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," " );
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] lighter = new List[n+1];
        List<Integer>[] heavier = new List[n+1];
        for(int i = 0 ; i <= n ; i++){
            lighter[i] = new ArrayList<>();
            heavier[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," " );
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            heavier[b].add(a); // a > b
            lighter[a].add(b);
        }
        int[] lightCnt = new int[n+1];
        int[] heavyCnt = new int[n+1];
        int result = 0;
        int limit = n/2 + 1;
        for(int i = 1 ; i <= n ; i ++){
            heavyCnt[i] = bfs(heavier,n,i);
            lightCnt[i] = bfs(lighter,n,i);
            if(heavyCnt[i] >= limit || lightCnt[i] >= limit){
                result++;
            }
        }
        System.out.println(result);
    }
}
