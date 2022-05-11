package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_7795 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int test = stoi.apply(st.nextToken());
        for(int t = 0 ; t < test ; t++){
            st = new StringTokenizer(br.readLine()," ");
            int aSize = stoi.apply(st.nextToken());
            int bSize = stoi.apply(st.nextToken());
            int[] a = new int[aSize];
            int[] b = new int[bSize];
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0 ; i < aSize ; i++){
                a[i] = stoi.apply(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0 ; i < bSize ; i++){
                b[i] = stoi.apply(st.nextToken());
            }
            Arrays.sort(a);
            Arrays.sort(b);
            int result = 0;
            for(int i = 0 ; i < aSize ; i++){
                int index = Arrays.binarySearch(b,a[i]);
//                System.out.println(a[i]+" "+i+" "+index);
                if(index < 0){
                    index = Math.abs(index) - 1;
                }else{
                    for(int j = index -1; j >= 0 ; j--){
                        if(b[index] == b[j]){
                            index = j;
                        }else{
                             break;
                        }
                    }
                }
                result += index;
            }
            System.out.println(result);
        }
    }
}
