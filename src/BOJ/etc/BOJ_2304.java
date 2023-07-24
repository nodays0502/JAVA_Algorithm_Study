package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2304 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            list.add(new int[]{a,b});
        }
        Collections.sort(list,(v1,v2)->{
            return v1[0] - v2[0];
        });
        int prevHeight = 0;
        int prevIndex = 0;
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            if(prevHeight < list.get(i)[1]){
                result += (list.get(i)[0] - prevIndex) * prevHeight;
                prevIndex = list.get(i)[0];
                prevHeight = list.get(i)[1];
            }
        }
        int firstIndex = prevIndex;
        int tempHeight = prevHeight;
        prevHeight = 0;
        prevIndex = 0;
        for(int i = n-1 ; i >= 0 ; i--){
            if(prevHeight < list.get(i)[1]){
                result += (prevIndex - list.get(i)[0]) * prevHeight;
                prevIndex = list.get(i)[0];
                prevHeight = list.get(i)[1];
            }
        }
        int secondIndex = prevIndex;
        result += (secondIndex - firstIndex + 1) * tempHeight;
        System.out.println(result);
    }
}
