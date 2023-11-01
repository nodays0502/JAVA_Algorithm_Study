package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14888 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi.apply(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = stoi.apply(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] operationCnt = new int[4]; // + - * /
        for (int i = 0; i < 4; i++) {
            operationCnt[i] = stoi.apply(st.nextToken());
        }
        // 입력
        int max = findMax(1, num[0], num, operationCnt, n);
        int min = findMin(1, num[0], num, operationCnt, n);
        System.out.println(max);
        System.out.println(min);
    }

    private static final int INF = 1_000_000_000;

    private static int findMin(int depth, int result, int[] num, int[] operationCnt, int n) {
        if (depth == n) {
            return result;
        }
        int min = INF;
        for (int i = 0; i < 4; i++) {
            if (operationCnt[i] == 0) {
                continue;
            }
            int next = result;
            if (i == 0) {
                next += num[depth];
            }
            if (i == 1) {
                next -= num[depth];
            }
            if (i == 2) {
                next *= num[depth];
            }
            if (i == 3) {
                next /= num[depth];
            }
            operationCnt[i]--;
            min = Math.min(min, findMin(depth + 1, next, num, operationCnt, n));
            operationCnt[i]++;
        }
        return min;
    }


    private static int findMax(int depth, int result, int[] num, int[] operationCnt, int n) {
        if (depth == n) {
            return result;
        }
        int max = -INF;
        for (int i = 0; i < 4; i++) {
            if (operationCnt[i] == 0) {
                continue;
            }
            int next = result;
            if (i == 0) {
                next += num[depth];
            }
            if (i == 1) {
                next -= num[depth];
            }
            if (i == 2) {
                next *= num[depth];
            }
            if (i == 3) {
                next /= num[depth];
            }
            operationCnt[i]--;
            max = Math.max(max, findMax(depth + 1, next, num, operationCnt, n));
            operationCnt[i]++;

        }
        return max;
    }
}
