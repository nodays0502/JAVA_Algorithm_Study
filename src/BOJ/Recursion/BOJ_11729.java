package BOJ.Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_11729 {
    static private int hanoi(int depth, int from, int to, int mid, StringBuilder sb){
        if(depth == 0){
            return 0;
        }
        int result = 1;
        result += hanoi(depth-1, from, mid, to,sb);
        sb.append(from+" "+to+"\n");
        result += hanoi(depth-1, mid, to, from,sb);
        return result;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        StringBuilder sb = new StringBuilder();
        System.out.println(hanoi(n,1,3,2, sb));
        System.out.println(sb.toString());
    }
}
