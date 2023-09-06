package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15658 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = stoi.apply(st.nextToken());
        }
        int[] operation = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = stoi.apply(st.nextToken());
        }
        int max = cal(1, num[0], num, operation, n, Math::max,MIN_VALUE);
        int min = cal(1, num[0], num, operation, n, Math::min,MAX_VALUE);
        System.out.println(max);
        System.out.println(min);
    }
    private static final int MAX_VALUE = 1_000_000_000;
    private static final int MIN_VALUE = -1_000_000_000;
    private static int cal(int depth, int number, int[] num, int[] operation, int n,
        Comparator<Integer> com,int value) {
        if (depth == n) {
            return number;
        }
        int result = value;
        for (int i = 0; i < 4; i++) {
            if (operation[i] == 0) {
                continue;
            }
            operation[i]--;
            int next = number;
            if (i == 0) {
                next = number + num[depth];
            }
            if (i == 1) {
                next = number - num[depth];
            }
            if (i == 2) {
                next = number * num[depth];
            }
            if (i == 3) {
                next = number / num[depth];
            }
            result = com.compare(result,
                cal(depth + 1, next, num, operation, n, com,value));
            operation[i]++;
        }
        return result;
    }
}
