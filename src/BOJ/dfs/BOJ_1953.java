package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1953 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        Set<Integer>[] hate = new HashSet[n+1];
        for(int i = 1 ; i <= n ; i++){
            hate[i] = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int cnt = stoi.apply(st.nextToken());
            for(int j = 0 ; j < cnt ; j++){
                int num = stoi.apply(st.nextToken());
                hate[i].add(num);
            }
        }
        boolean[] choice = new boolean[n+1];
        dfs(1,choice,n,hate);
    }
    private static boolean dfs(int depth, boolean[] choice,int n,Set<Integer>[] hate){
        if(depth == n+1){
            int cnt = 0;
            for(int i = 1 ; i <= n ; i++){
                if(choice[i]){
                    cnt++;
                }
            }
            System.out.println(cnt);
            for(int i = 1 ; i <= n ; i++){
                if(choice[i]){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
            System.out.println(n-cnt);
            for(int i = 1 ; i <= n ; i++){
                if(!choice[i]){
                    System.out.print(i+" ");
                }
            }
            return true;
        }
        boolean firstTeam = true;
        boolean secondTeam = true;
        for(int i = 1 ; i < depth ; i++){
            if(choice[i] && hate[i].contains(depth)){
                firstTeam = false;
            }
            if(!choice[i] && hate[i].contains(depth)){
                secondTeam = false;
            }
        }
        if(firstTeam){
            choice[depth] = true;
            if(dfs(depth+1,choice,n,hate)){
                return true;
            }
        }
        if(secondTeam){
            choice[depth] = false;
            if(dfs(depth+1,choice,n,hate)){
                return true;
            }
        }
        return false;
    }

}
