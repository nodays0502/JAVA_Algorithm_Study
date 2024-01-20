package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1700_2 {
    private static final int ALPHA_SIZE = 26;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] input = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < k ; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        int result = cal(n,k,input);
        System.out.println(result);
    }
    private static int cal(int n,int k,int[] input){
        int cnt = 0;
        int result = 0;
        Set<Integer> used = new HashSet<>();
        for(int i = 0 ; i < k ; i++){
            if(used.contains(input[i])){
                continue;
            }
            used.add(input[i]);
            cnt++;
            if(cnt > n){
                result++;
                int maxType = 0;
                int maxIndex = 0;
                for(int type : used){
                    if(type == input[i]){
                        continue;
                    }
                    for(int j = i + 1 ; j < k ; j++){
                        if(input[j] == type){
                            if(maxIndex < j){
                                maxIndex = j;
                                maxType = input[j];
                            }
                            break;
                        }
                        if(j == k-1){
                            maxIndex = k;
                            maxType = type;
                        }
                    }
                }
                used.remove(maxType);
            }
        }
        return result;
    }
}