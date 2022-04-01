package BOJ.Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_15686_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        List<int[]> shop = new ArrayList<>();
        List<int[]> house = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi.apply(st.nextToken());
                if (map[i][j] == 2) {
                    shop.add(new int[]{i, j});
                }
                if (map[i][j] == 1) {
                    house.add(new int[]{i, j});
                }
            }
        }
        int[] choice = new int[m];
        int result = dfs(m, map, n, shop, house,choice,0);
        System.out.println(result);
    }

    private static final int INF = 987654321;

    private static int dfs(int depth, int[][] map, int n, List<int[]> shop, List<int[]> house, int[] choice,int start) {
        if (depth == 0) {
            int result = 0;
            for(int[] housePoint : house){
                int temp = INF;
                for(int num : choice){
                    int[] shopPoint = shop.get(num);
                    int y = shopPoint[0];
                    int x = shopPoint[1];
                    temp = Math.min(Math.abs(housePoint[0] - shopPoint[0]) + Math.abs(housePoint[1] - shopPoint[1]),temp);
                }
                result += temp;
//                System.out.println(result);
            }
            return result;
        }
        int result = INF;
        for (int i = start; i < shop.size(); i++) {
            choice[depth-1] = i;
            result = Math.min(dfs(depth - 1, map, n, shop, house,choice,i + 1), result);
        }
        return result;
    }
}
