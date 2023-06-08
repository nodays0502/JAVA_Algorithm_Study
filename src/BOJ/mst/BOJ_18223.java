package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18223 {
    private static final String SAVE = "SAVE HIM";
    private static final String BYE = "GOOD BYE";
    private static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int v = stoi.apply(st.nextToken());
        int e = stoi.apply(st.nextToken());
        int p = stoi.apply(st.nextToken());
        List<int[]>[] map = new List[v+1];
        for(int i = 0 ; i <= v; i++){
            map[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < e ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int weight = stoi.apply(st.nextToken());
            map[a].add(new int[]{b,weight});
            map[b].add(new int[]{a,weight});
        }
        if(dij(1,v,v,map) == dij(1,p,v,map)+dij(p,v,v,map)){
            System.out.println(SAVE);
        }else{
            System.out.println(BYE);
        }
    }

    private static int dij(int start, int target,int v,List<int[]>[] map) {
        int result = 0;
        boolean[] visited = new boolean[v+1];
        int[] distance = new int[v+1];
        Arrays.fill(distance,INF);
        distance[start] = 0;

        for(int i = 1 ; i <= v ; i++){
            int min = INF;
            int minIndex = 0;
            for(int j = 1 ; j <= v ; j++){
                if(!visited[j] && min > distance[j]){
                    minIndex = j;
                    min = distance[j];
                }
            }
            visited[minIndex] = true;
//            System.out.println("minIndex:"+minIndex);
            if(minIndex == target){
//                System.out.println(distance[minIndex]);
                return distance[minIndex];
            }
            for(int[] next : map[minIndex]){
                if(!visited[next[0]] && distance[next[0]] > min + next[1]){
                    distance[next[0]] = min + next[1];
                }
            }
        }
        return -1;
    }
}
