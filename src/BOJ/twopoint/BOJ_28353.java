package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_28353 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[] weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            weight[i] = stoi.apply(st.nextToken());
        }
        Arrays.sort(weight);
        int result = countHappyPeople(weight,n,k);
        System.out.println(result);
    }

    private static int countHappyPeople(int[] weight, int n, int k) {
        int startIndex = 0;
        int endIndex = n-1;
        int cnt = 0;
        while(startIndex < endIndex){
            int sumWeight = weight[startIndex] + weight[endIndex];
            if(sumWeight > k){
                endIndex--;
                continue;
            }
            cnt++;
            startIndex++;
            endIndex--;
        }
        return cnt;
    }
}
