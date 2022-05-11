package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_14889 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        boolean[] isSelected = new boolean[n];
        int result = dfs(n / 2, 0,isSelected, map, n);
        System.out.println(result);
    }

    private static int dfs(int depth,int start, boolean[] isSelected, int[][] map, int n) {
        if (depth == 0) {
            int[] sum = {0, 0};
//            System.out.println(Arrays.toString(isSelected));
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isSelected[i] != isSelected[j] || i == j) {
                        continue;
                    }
                    int temp = map[i][j] + map[j][i];
                    if (isSelected[i]) {
                        sum[0] += temp;
                    } else {
                        sum[1] += temp;
                    }
                }
            }
            return Math.abs(sum[0] - sum[1]);
        }
        int result = Integer.MAX_VALUE;
        for (int i = start; i < n; i++) {
            isSelected[i] = true;
            result = Math.min(result, dfs(depth - 1, i+1 ,isSelected, map, n));
            isSelected[i] = false;
        }
        return result;
    }
}
