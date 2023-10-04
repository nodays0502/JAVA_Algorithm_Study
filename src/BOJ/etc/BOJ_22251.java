package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_22251 {

    private static final boolean[][] NUMBER = {
        {true, true, true, false, true, true, true}, // 0
        {false, false, true, false, true, false, false}, // 1
        {false, true, true, true, false, true, true}, // 2
        {false, true, true, true, true, true, false}, // 3
        {true, false, true, true, true, false, false}, // 4
        {true, true, false, true, true, true, false}, // 5
        {true, true, false, true, true, true, true}, // 6
        {false, true, true, false, true, false, false}, // 7
        {true, true, true, true, true, true, true}, // 8
        {true, true, true, true, true, true, false} // 9
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int p = stoi.apply(st.nextToken());
        int x = stoi.apply(st.nextToken());
        int result = cal(0, x, k, p, n) - 1;
        System.out.println(result);
    }

    private static int cal(int depth, int now, int digit, int p, int maxFloor) {
        if(depth == digit && now >= 1 && now <= maxFloor){
            return 1;
        }
        if(depth == digit){
            return 0;
        }
        int result = 0;
        int standard = 10;
        for (int i = 0; i < digit - depth-1; i++) {
            standard *= 10;
        }
        int num = now % standard / (standard / 10);
        int tempNum = (now / standard) * standard + now % (standard / 10);
        for(int i = 0 ; i < 10 ; i++){
            int diffCnt = 0;
            for(int j = 0 ; j < 7 ; j++){
                if(NUMBER[i][j] != NUMBER[num][j]){
                    diffCnt++;
                }
            }
            if(diffCnt > p){
                continue;
            }
            int next = (tempNum + i * standard / 10);
            result += cal(depth+1,next,digit,p-diffCnt,maxFloor);
        }
        return result;
    }
}
