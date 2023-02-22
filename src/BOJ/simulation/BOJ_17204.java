package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17204 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[] input = new int[n];
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(br.readLine());
        }
        int result = bfs(input,n,m);
        System.out.println(result);
    }

    private static int bfs(int[] input, int n, int m) {
        int result = -1;
        boolean[] visited = new boolean[n];
        int now = 0;
        int cnt = 0;
        while(true){
            cnt++;
            int next = input[now];
            if(next == m){
                result = cnt;
                break;
            }
            if(!visited[next]){
                visited[next] = true;
                now = next;
            }else{
                break;
            }
        }
        return result;
    }

}
