package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_16198 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        boolean[] visited = new boolean[n];
        int result = dfs(n-2,input,visited);
        System.out.println(result);
    }

    private static int dfs(int depth, int[] input, boolean[] visited) {
        if(depth == 0){
            return 0;
        }
        int result = 0;
        for(int i = 1 ; i < input.length-1 ; i++){
            if(visited[i]){
               continue;
            }
            visited[i] = true;
            int next = findNext(input,i,visited);
            int prev = findPrev(input,i,visited);
            result = Math.max(result,next * prev + dfs(depth-1,input,visited));
            visited[i] = false;
        }
        return result;
    }

    private static int findPrev(int[] input, int i, boolean[] visited) {
        while(visited[i]){
            i++;
        }
        return input[i];
    }

    private static int findNext(int[] input, int i, boolean[] visited) {
        while(visited[i]){
            i--;
        }
        return input[i];
    }

}
