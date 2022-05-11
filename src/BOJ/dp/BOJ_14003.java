package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] input = new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < n ; i++){
            input[i] = stoi.apply(st.nextToken());
        }
        lis(input,n);
    }
    private static void lis(int[] input, int n){
        int[] path = new int[n];
        int[] nowIndex = new int[n];
        int[] temp = new int[n];
        Arrays.fill(path, -1);
        int size = 0;
        for(int i = 0 ; i < n ; i++){
            int index = Arrays.binarySearch(temp,0,size,input[i]);
            if(index >= 0){
                continue;
            }
            index = -index - 1;
            temp[index] = input[i];
            nowIndex[index] = i;
            if(index > 0){
                path[i] = nowIndex[index-1];
            }
            if(index >= size){
                size++;
            }
        }

        List<Integer> result = new ArrayList<>();
        int index = nowIndex[size-1];
        while(index != -1){
            result.add(input[index]);
            index = path[index];
        }
        System.out.println(result.size());
        for(int i = result.size()-1 ; i >= 0 ; i--){
            System.out.print(result.get(i)+" ");
        }
    }
}
