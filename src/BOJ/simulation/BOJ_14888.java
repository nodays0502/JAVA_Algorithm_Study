package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14888 {
    private static int dfsMax(int depth , int[] input, int[] cnt){ // + - * /
        if(depth == 0){
            return input[depth];
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0 ; i < 4 ; i++){
            if(cnt[i] == 0){
                continue;
            }
            cnt[i]--;
            if(i == 0){
                result = Math.max(result, dfsMax(depth-1,input,cnt) + input[depth]);
            } else if(i == 1){
                result = Math.max(result, dfsMax(depth-1,input,cnt) - input[depth]);
            }else if(i == 2){
                result = Math.max(result, dfsMax(depth-1,input,cnt) * input[depth]);
            }else if(i == 3){
                result = Math.max(result, dfsMax(depth-1,input,cnt) / input[depth]);
            }
            cnt[i]++;
        }
        return result;
    }
    private static int dfsMin(int depth , int[] input, int[] cnt){ // + - * /
        if(depth == 0){
            return input[depth];
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < 4 ; i++){
            if(cnt[i] == 0){
                continue;
            }
            cnt[i]--;
            if(i == 0){
                result = Math.min(result, dfsMin(depth-1,input,cnt) + input[depth]);
            } else if(i == 1){
                result = Math.min(result, dfsMin(depth-1,input,cnt) - input[depth]);
            }else if(i == 2){
                result = Math.min(result, dfsMin(depth-1,input,cnt) * input[depth]);
            }else if(i == 3){
                result = Math.min(result, dfsMin(depth-1,input,cnt) / input[depth]);
            }
            cnt[i]++;
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        int[] cnt = new int[4];
        for(int i = 0 ; i < 4; i++){
            cnt[i] = stoi.apply(st.nextToken());
        }
        System.out.println(dfsMax(n-1 , input, cnt));
        System.out.println(dfsMin(n-1 , input, cnt));
    }
}
