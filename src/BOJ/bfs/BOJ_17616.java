package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17616 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int x = stoi.apply(st.nextToken());
        List<Integer>[] lose = new List[n+1];
        List<Integer>[] win = new List[n+1];
        for(int i = 1; i <= n ; i++){
            lose[i] = new LinkedList<>();
            win[i] = new LinkedList<>();
        }
        for(int i = 0 ;  i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int loser = stoi.apply(st.nextToken());
            int winner = stoi.apply(st.nextToken());
            lose[loser].add(winner);
            win[winner].add(loser);
        }
        int loserCnt = countPeople(x,lose,n);
        int winnerCnt = countPeople(x,win,n);
        System.out.println( winnerCnt +" "+ (n - loserCnt + 1) );
    }
    private static int countPeople(int num, List<Integer>[] map,int n){
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(num);
        visited[num] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            cnt++;
            for(int next : map[now]){
                if(visited[next]){
                    continue;
                }
                visited[next] = true;
                q.offer(next);
            }
        }
        return cnt;
    }
}
