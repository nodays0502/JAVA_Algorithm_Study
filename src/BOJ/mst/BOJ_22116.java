package BOJ.mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_22116 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = kruskal(map,n);
        System.out.println(result);
    }
    private static final int[] DY = {-1,0,1,0};
    private static final int[] DX = {0,1,0,-1};
    private static class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    private static int kruskal(int[][] map, int n) {
        List<Edge> edges = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0 ; k < 2; k++){
                    int ny = i + DY[k];
                    int nx = j + DX[k];
                    if(!checkBound(ny,nx,n)){
                        continue;
                    }
                    int start = changePositionToNumber(i,j,n);
                    int end = changePositionToNumber(ny,nx,n);
                    edges.add(new Edge(start,end,Math.abs(map[i][j] - map[ny][nx])));
                }
            }
        }
        int[] parent = new int[n*n];
        for(int i = 0 ; i < n*n ; i++){
            parent[i] = i;
        }
        Collections.sort(edges,(o1,o2)->o1.weight-o2.weight);
        int result = 0;
        for(Edge edge : edges){
            if (unionSet(edge.start,edge.end,parent)){
                result = Math.max(result,edge.weight);
            }
            if(findSet(0,parent) == findSet(n*n-1,parent)){
                break;
            }
        }
        return result;

    }
    private static int findSet(int position,int[] parent){
        if(position == parent[position]){
            return position;
        }
        return parent[position] = findSet(parent[position],parent);
    }
    private static boolean unionSet(int a,int b,int[] parent){
        int aParent = findSet(a,parent);
        int bParent = findSet(b,parent);
        if(aParent == bParent){
            return false;
        }
        parent[aParent] = bParent;
        return true;
    }
    private static int changePositionToNumber(int y,int x,int n){
        return n*y + x;
    }
    private static boolean checkBound(int ny, int nx, int n) {
        if(ny >= 0 && ny < n && nx >= 0 && nx < n){
            return true;
        }
        return false;
    }
}
