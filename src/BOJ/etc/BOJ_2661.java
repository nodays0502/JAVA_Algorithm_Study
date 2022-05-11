package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2661 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[] numbers = new int[n];
        System.out.println(dfs(0, numbers, n));
//        isGood(new int[] {1,2,1,2},4);
    }

    private static String INF = "9";

    private static String dfs(int depth, int[] numbers, int n) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(numbers[i]);
            }
            return sb.toString();
        }
        String result = INF;
        for (int i = 1; i <= 3; i++) {
            if (depth > 0 && i == numbers[depth - 1]) {
                continue;
            }
            numbers[depth] = i;
            if (!isGood(numbers, depth+1)) {
                continue;
            }
            String temp = dfs(depth + 1, numbers, n);
            if (!INF.equals(temp)) {
                result = temp;
                break;
            }
        }
        return result;
    }

    private static boolean isGood(int[] numbers, int n) {
        for (int i = 1; i <= n / 2; i++) { // 길이
            for (int j = 0; j <= n - 2 * i; j++) { // 시작 점
                boolean isPartSame = true;
                for (int k = 0; k < i; k++) {
                    if (numbers[j + k] != numbers[j + i + k]) {
                        isPartSame = false;
                        break;
                    }
                }
                if (isPartSame) {
                    return false;
                }
            }
        }
        return true;
    }
}
