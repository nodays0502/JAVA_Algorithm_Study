package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1459 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        long y = stoi.apply(st.nextToken());
        long x = stoi.apply(st.nextToken());
        long w = stoi.apply(st.nextToken());
        long s = stoi.apply(st.nextToken());
        long result = 0;
        if(2*w > s){
            long length = Math.min(y,x);
            y -= length;
            x -= length;
            result += length * s;
        }
        long sum = y+x;
        if(sum % 2 == 0){
            result += sum * Math.min(w,s);
        }else{
            result += 2 * (sum /2)  * Math.min(w,s) + w;
        }
        System.out.println(result);
    }
}
