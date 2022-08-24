package BOJ.twopoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class BOJ_16472 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        String command = br.readLine();
        int result = cal(command,n);
        System.out.println(result);
    }
    private static final int ALPHABET_SIZE = 26;
    private static int cal(String command, int n) {
        int result = 0;
        int si = 0;
        int ei = 0;
        int cnt = 0;
        int[] used = new int[ALPHABET_SIZE];
        while(true){
            result = Math.max(result,ei-si);
            if(ei >= command.length()){
                break;
            }
            int now = command.charAt(ei) - 'a';
            if(used[now] > 0 || cnt < n){
                if(used[now] == 0){
                    cnt++;
                }
                used[now]++;
                ei++;
                continue;
            }
            if(cnt >= n){
                int prev = command.charAt(si) - 'a';
                used[prev]--;
                if(used[prev] == 0){
                    cnt--;
                }
                si++;
                continue;
            }
        }
        return result;
    }
}
