package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_10025 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        List<int[]> ices = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int weight = stoi.apply(st.nextToken());
            int position = stoi.apply(st.nextToken());
            ices.add(new int[] {weight,position});
        }
        ices.sort((o1,o2)-> o1[1] - o2[1]);
        int result = cal(ices,n,k);
        System.out.println(result);
    }

    private static int cal(List<int[]> ices, int n,int k) {
        int si = 0;
        int ei = 0;
        int distance = 2*k + 1;
        int sum = 0;
        int result = 0;
        while(ei < n){
            if(ices.get(ei)[1] - ices.get(si)[1] <= distance){
                sum += ices.get(ei++)[0];
                result = Math.max(result,sum);
            }else{
                sum -= ices.get(si++)[0];
            }
        }
        return result;
    }
}
