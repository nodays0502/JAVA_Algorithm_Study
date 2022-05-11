package BOJ.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_2776 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int t = 0 ; t < test ; t++){
            st = new StringTokenizer(br.readLine()," ");
            int n = stoi.apply(st.nextToken());
            int[] input = new int[n];
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0 ; i < n ; i++){
                input[i] = stoi.apply(st.nextToken());
            }
            Arrays.sort(input);
            st = new StringTokenizer(br.readLine()," ");
            int m = stoi.apply(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0 ; i < m ; i++){
                int num = stoi.apply(st.nextToken());
                int index = Arrays.binarySearch(input,num);
                if(index >= 0){
//                    System.out.println(1);
                    sb.append(1+"\n");
                }else{
//                    System.out.println(0);
                    sb.append(0+"\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
