package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1024 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        int l = stoi.apply(st.nextToken());
        int startNum = 0;
        int endNum = 0;
        int sum = 0;
        int[] result = null;
        while(endNum <= n + 1){
            if(endNum - startNum > 100){
                sum -= startNum;
                startNum++;
                continue;
            }
            if(sum < n){
                sum += endNum;
                endNum++;
            }else if(sum == n){
                if(endNum - startNum >= l && result == null){
                    result = new int[]{startNum, endNum};
                }else if(endNum - startNum >= l && result[1] - result[0] > endNum - startNum){
                    result = new int[]{startNum,endNum};
                }
                sum -= startNum;
                startNum++;
            }else{
                sum -= startNum;
                startNum++;
            }
        }
        if(result == null){
            System.out.println(-1);
            return ;
        }
        for(int i = result[0] ; i < result[1] ; i++){
            System.out.print(i+" ");
        }
    }
}
