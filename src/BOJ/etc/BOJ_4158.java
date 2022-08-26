package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_4158 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Function<String,Integer> stoi = Integer::parseInt;
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = stoi.apply(st.nextToken());
            int m = stoi.apply(st.nextToken());
            if(n == 0 && m == 0){
                break;
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 0 ; i < n ; i++){
                int num = stoi.apply(br.readLine());
                set.add(num);
            }
            int cnt = 0;
            for(int i = 0 ; i < m ; i++){
                int num = stoi.apply(br.readLine());
                if(set.contains(num)){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
