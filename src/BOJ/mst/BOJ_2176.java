package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2176 {
    private static class Node{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static final int LIMIT = 2147483647;
    private static int dij(List<Node>[] map,int n){
        int[] distance = new int[n+1];
        int[] count = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance,LIMIT);
        distance[1] = 0;
        count[1] = 1;
        for(int i = 0 ; i < n ; i++){
            int minIndex = 1;
            int minValue = LIMIT;
//            System.out.println(Arrays.toString(distance));
//            System.out.println(Arrays.toString(count));
//            System.out.println(Arrays.toString(visited));
            for(int j = 1 ; j <= n ; j++){
                if(!visited[j] && minValue > distance[j]){
                    minIndex = j;
                    minValue = distance[j];
                }
            }
//            System.out.println(minIndex);
            if(minValue == LIMIT || minIndex == 2){
                break;
            }
            visited[minIndex] = true;
            for(int j = 0 ; j < map[minIndex].size() ; j++){
                Node next = map[minIndex].get(j);
                if(!visited[next.end] && distance[next.end] >= minValue + next.weight){
                    distance[next.end] = minValue + next.weight;
                    count[next.end] += count[minIndex];
                }
            }
        }
        return count[2];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Node>[] map = new List[n+1];
        for(int i = 1 ; i <= n ; i++){
            map[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            map[a].add(new Node(b,c));
            map[b].add(new Node(a,c));
        }
        System.out.println(dij(map,n));
    }
}
