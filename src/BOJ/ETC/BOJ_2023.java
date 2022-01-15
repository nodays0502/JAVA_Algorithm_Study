package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2023 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int size = 1;
        for(int i = 0 ; i < n ; i++){
            size *= 10;
        }
        StringBuilder sb = new StringBuilder();
        dfs(0,0,n,sb);
        System.out.println(sb.toString());
    }
    private static void dfs(int num, int depth, int n, StringBuilder sb){
//        System.out.println(num);
        if(!checkPrim(num)){
            return ;
        }
        if(depth == n){
            sb.append(num+"\n");
            return ;
        }
        for(int i = 1 ; i < 10 ; i++){
            dfs(num * 10 + i,depth+1,n,sb);
        }
    }
    private static boolean checkPrim(int num){
        if(num == 0){
            return true;
        }else if(num == 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num) ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
