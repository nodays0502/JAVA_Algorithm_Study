package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.AnnotatedType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_13424 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int testCnt = stoi.apply(st.nextToken());
        for(int t = 0 ; t < testCnt ; t++){
            st = new StringTokenizer(br.readLine());
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            List<int[]>[] map = new List[n+1];
            for(int i = 1 ; i <= n ; i++){
                map[i] = new LinkedList<>();
            }
            for(int i = 0 ; i < m ; i++){
                st = new StringTokenizer(br.readLine());
                int a = stoi.apply(st.nextToken());
                int b = stoi.apply(st.nextToken());
                int c = stoi.apply(st.nextToken());
                map[a].add(new int[]{b,c});
                map[b].add(new int[]{a,c});
            }
            st = new StringTokenizer(br.readLine());
            int k = stoi.apply(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] people = new int[k];
            for(int i = 0 ; i < k ; i++){
                people[i] = stoi.apply(st.nextToken());
            }
            int result = cal(map,n,people,k);
            System.out.println(result);
        }
    }

    private static int cal(List<int[]>[] map, int n, int[] people, int k) {
        int[] distance = new int[n+1];
        for(int num : people){
            int[] temp = dij(num,map,n);
            for(int i = 1 ; i <= n ; i++){
                distance[i] += temp[i];
            }
        }
        int minIndex = 1;
//        System.out.println(Arrays.toString(distance));
        for(int i = 1 ; i <= n ; i++){
            if(distance[minIndex] > distance[i]){
                minIndex = i;
            }
        }
        return minIndex;
    }
    private static final int INF = 987654321;
    private static int[] dij(int num, List<int[]>[] map, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance,INF);
        distance[num] = 0;
        distance[0] = 0;
        for(int i = 0 ; i < n ; i++){
            int minIndex = 1;
            int minValue = INF;
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minIndex = j;
                    minValue = distance[j];
                }
            }
            visited[minIndex] = true;
            for(int[] next : map[minIndex]){
                int nextIndex = next[0];
                int nextValue = next[1];
                if(!visited[nextIndex] && distance[nextIndex] > minValue + nextValue){
                    distance[nextIndex] = minValue + nextValue;
                }
            }
        }
        return distance;
    }
}
