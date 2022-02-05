package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2617 {
    private static void bfs(List<Integer>[] list1, int[] cnt, int n){

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," " );
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer>[] lighter = new List[n+1];
        List<Integer>[] heavier = new List[n+1];
        for(int i = 0 ; i < m ; i++){
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            heavier[a].add(b);
            lighter[b].add(a);
        }
        int[] lightCnt = new int[n+1];
        int[] heavyCnt = new int[n+1];

    }
}
