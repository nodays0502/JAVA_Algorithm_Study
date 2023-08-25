package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1246 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        List<Integer> money = new ArrayList<Integer>();
        for(int i = 0 ; i < m ; i++){
            money.add(stoi.apply(br.readLine()));
        }
        int[] result = cal(money,n,m);
        System.out.println(result[0]+" "+result[1]);
    }

    private static int[] cal(List<Integer> money, int n, int m) {
        Collections.sort(money);
        int[] result = null;
        for(int i = 0 ; i < m ; i++){
            int temp = money.get(i) * Math.min(m - i,n);
            if(result == null || result[1] < temp){
                result = new int[]{money.get(i),temp};
            }
        }
        return result;
    }
}
