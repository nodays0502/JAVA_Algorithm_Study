package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2138 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        String command = br.readLine();
        int[] input = new int[n+1];
        int[] target = new int[n+1];
        for(int i = 0 ; i < n ; i++){
            input[i+1] = stoi.apply(command.charAt(i)+"");
        }
        command = br.readLine();
        for(int i = 0 ; i < n ; i++){
            target[i+1] = stoi.apply(command.charAt(i)+"");
        }
        boolean[] isSwitch = new boolean[n+1];
        int result = dfs(n,input,target,isSwitch);
//        System.out.println(result);
        isSwitch = new boolean[n+1];
        isSwitch[0] = true;
        result = Math.min(dfs(n,input,target,isSwitch),result);
        if(result == INF){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
    static final int INF = Integer.MAX_VALUE;
    private static int dfs(int n , int[] input, int[] target, boolean[] isSwitch) {
        int cnt = 0;
        if(isSwitch[0]){
            cnt++;
        }
        boolean flag = true;
        for(int i = 1 ; i <= n ; i++){
            if(i == n ){
                if((input[i] + cnt) % 2 != target[i]){
                    flag = false;
                    break;
                }
            } else if( (input[i] + cnt) % 2 != target[i]){
                isSwitch[i] = true;
                cnt++;
            }
            if(i >= 2 && isSwitch[i-2]){
                cnt--;
            }
        }
        if(flag){
            int cntSwitch = 0;
            for(int i = 0 ; i < n ; i++){
                if(isSwitch[i]){
                    cntSwitch++;
                }
            }
            return cntSwitch;
        }else{
            return INF;
        }
    }
}
