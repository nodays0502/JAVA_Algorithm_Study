package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1043 {
    static int findSet(int a,int[] parent){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = findSet(parent[a],parent);
    }
    static boolean union(int a, int b,int[] parent){
        int aRoot = findSet(a,parent);
        int bRoot = findSet(b,parent);
        if(aRoot == bRoot){
            return false;
        }
        parent[aRoot] = bRoot;
        return true;
    }
    static boolean findParty(int a, int b,int[] parent){
        int aRoot = findSet(a,parent);
        int bRoot = findSet(b,parent);
        if(aRoot == bRoot){
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cnt = stoi.apply(st.nextToken());
        int knowNum = 0;
        int[] parent = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }
        for(int i = 0 ; i < cnt ; i++){
            int knowPeople = stoi.apply(st.nextToken());
            parent[knowPeople] = 0;
            knowNum = knowPeople;
        }
        int result = 0;
        int[][] input = new int[m][];
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            cnt = stoi.apply(st.nextToken());
            input[i] = new int[cnt];
            for(int j = 0 ; j < cnt; j++){
                input[i][j] = stoi.apply(st.nextToken());
                if(j >= 1){
//                    System.out.println(input[i][0]+" "+input[i][j]);
                    union(input[i][0],input[i][j],parent);
                }
            }
        }
//        System.out.println(Arrays.toString(parent));
        for(int i = 0 ; i < m ; i++){
            if(findParty(knowNum,input[i][0],parent)){
                result++;
            }
        }
        System.out.println(result);
    }

}
