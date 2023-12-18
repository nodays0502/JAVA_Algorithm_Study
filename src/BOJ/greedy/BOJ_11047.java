package BOJ.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] money = new int[n];
        for(int i = 0 ; i < n ; i++){
            money[i] = Integer.parseInt(br.readLine());
        }
//        Arrays.sort(money);
        int result = cal(n-1,k,money,n);
        System.out.println(result);
    }
    private static final int INF = 987654321;
    private static boolean findResult = false;
    private static int cal(int depth, int left, int[] money, int n) {
        if(findResult){
            return INF;
        }
        if(left == 0){
            findResult = true;
            return 0;
        }
        if(depth < 0){
            return INF;
        }
        int result = INF;
        for(int i = left/money[depth] ; i >= 0 ; i--){
            result = Math.min(result, cal(depth-1,left - i * money[depth],money,n) + i);
        }
        return result;
    }

}
