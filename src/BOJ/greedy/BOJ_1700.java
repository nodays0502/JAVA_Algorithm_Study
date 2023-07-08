package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1700 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] input = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < k ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        int result = cal(input,n,k);
        System.out.println(result);
    }

    private static final int INF = 987654321;

    private static int cal(int[] input, int n, int k) {
        Queue<Integer>[] q = new Queue[k+1];
        for(int i = 0 ; i <= k ; i++){
            q[i] = new LinkedList<>();
        }
        for(int i = 0 ; i < k ; i++){
            q[input[i]].add(i);
        }
        int result = 0;
        int cnt = 0;
        boolean[] nowUsed = new boolean[k+1];
        for(int i = 0 ; i < k ; i++){
            int now = input[i];
            if(nowUsed[now]){
                q[now].poll();
                continue;
            }
            if(cnt < n){
                cnt++;
                nowUsed[now] = true;
                q[now].poll();
            }else{
                int value = 0;
                int maxIndex = 0;
                for(int j = 1 ; j <= k ; j++){
                    if(!nowUsed[j]){
                        continue;
                    }
                    if(q[j].isEmpty() || maxIndex < q[j].peek()){
                        value = j;
                        if(q[j].isEmpty()){
                            maxIndex = INF;
                            break;
                        }else{
                            maxIndex = q[j].peek();
                        }
                    }
                }
                nowUsed[value] = false;
                nowUsed[now] = true;
                q[now].poll();
                result++;
            }
        }
        return result;
    }
}
