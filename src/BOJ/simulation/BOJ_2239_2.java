package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;

public class BOJ_2239_2 {

    private static int SIZE = 9;

    private static boolean fillMap(int y, int x, int[][] map) {
        if (y >= SIZE) {
            return true;
        }
        int ny = y;
        int nx = x;
        nx++;
        if (nx >= SIZE) {
            nx = 0;
            ny++;
        }
        if (map[y][x] == 0) {
            boolean[] used = checkValid(y, x, map);
            for (int i = 1; i <= SIZE; i++) {
                if (used[i]) {
                    continue;
                }
                map[y][x] = i;
                if (fillMap(ny, nx, map)) {
                    return true;
                }
            }
            map[y][x] = 0;
            return false;
        } else {
            return fillMap(ny, nx, map);
        }
    }

    private static boolean[] checkValid(int y, int x, int[][] map) {
        boolean[] used = new boolean[SIZE + 1];
        for(int i = 0 ; i < SIZE ; i++){
            used[map[y][i]] = true;
            used[map[i][x]] = true;
        }
        int ny = y / 3;
        int nx = x / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = map[3 * ny + i][3 * nx + j];
                used[num] = true;
            }
        }
        return used;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        int[][] map = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            String command = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = stoi.apply(command.charAt(j) + "");
            }
        }
        fillMap(0, 0, map);
        print(map);
    }

    private static void print(int[][] map) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
