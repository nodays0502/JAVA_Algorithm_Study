package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1183 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        StringTokenizer st;
        List<Integer> list = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            list.add(a-b);
        }
        if(n % 2 != 0){
            System.out.println(1);
            return ;
        }
        Collections.sort(list);
        System.out.println( Math.abs(list.get(n/2) - list.get(n/2-1)) + 1);
    }
}
