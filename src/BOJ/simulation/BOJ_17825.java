package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17825 {

    private static final int SIZE = 10;
    private static final int MAP_SIZE = 33;
    private static final int PHONE_SIZE = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        int[] input = new int[SIZE];
//        int[] map = new int[MAP_SIZE];
        int[] phone = new int[PHONE_SIZE];
        int[] redDir = new int[MAP_SIZE];
        boolean[] isBlue = new boolean[MAP_SIZE];
        int[] blueDir = new int[MAP_SIZE];
        int[] score = new int[MAP_SIZE];
        init(redDir, isBlue, blueDir, score);
        for (int i = 0; i < SIZE; i++) {
            input[i] = stoi.apply(st.nextToken());
        }
        int result = dfs(0, input, phone, redDir, isBlue, blueDir, score);
        System.out.println(result);
    }

    private static int dfs(int depth, int[] input, int[] phone, int[] redDir, boolean[] isBlue,
        int[] blueDir, int[] score) {
        if (depth == SIZE) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < PHONE_SIZE; i++) {
            int now = phone[i];
            int next = now;
            int cnt = input[depth];
            if (isBlue[next]) {
                next = blueDir[next];
                cnt--;
            }
            for (int j = 0; j < cnt; j++) {
                if (next == MAP_SIZE - 1) {
                    break;
                }
                next = redDir[next];
            }
            if (next >= MAP_SIZE - 1) {
                next = MAP_SIZE - 1;
                phone[i] = next;
                result = Math.max(result,
                    dfs(depth + 1, input, phone, redDir, isBlue, blueDir, score));
                phone[i] = now;
                continue;
            }
            boolean isCan = true;
            for (int j = 0; j < PHONE_SIZE; j++) {
                if (i == j) {
                    continue;
                }
                if (next == phone[j]) {
                    isCan = false;
                    break;
                }
            }
            if (isCan) {
                phone[i] = next;
                result = Math.max(result,
                    dfs(depth + 1, input, phone, redDir, isBlue, blueDir, score) + score[next]);
                phone[i] = now;
            }
        }
        return result;
    }

    private static void init(int[] redDir, boolean[] isBlue, int[] blueDir, int[] score) {
        for (int i = 0; i <= 20; i++) {
            redDir[i] = i + 1;
            score[i] = 2 * i;
        }
        redDir[20] = MAP_SIZE - 1;

        isBlue[5] = true;
        isBlue[10] = true;
        isBlue[15] = true;
        blueDir[5] = 21;
        blueDir[10] = 24;
        blueDir[15] = 28;

        redDir[21] = 22;
        score[21] = 13;

        redDir[22] = 23;
        score[22] = 16;

        redDir[23] = 29;
        score[23] = 19;

        redDir[24] = 25;
        score[24] = 22;

        redDir[25] = 29;
        score[25] = 24;

        redDir[26] = 29;
        score[26] = 26;

        redDir[27] = 26;
        score[27] = 27;

        redDir[28] = 27;
        score[28] = 28;

        redDir[29] = 30;
        score[29] = 25;

        redDir[30] = 31;
        score[30] = 30;

        redDir[31] = 20;
        score[31] = 35;
    }
}
