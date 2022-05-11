package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class BOJ_2239 {

    private static int SIZE = 9;

    private static boolean fillMap(int y, int x, int[][] map) {
        if (y >= SIZE) {
            return true;
        }
        if (map[y][x] == 0) {
            for (int i = 1; i <= SIZE; i++) {
                map[y][x] = i;
                if (checkValid(y, x, map)) {
                    int ny = y;
                    int nx = x;
                    nx++;
                    if (nx >= SIZE) {
                        nx = 0;
                        ny++;
                    }
                    if (fillMap(ny, nx, map)) {
                        return true;
                    }
                }
            }
            map[y][x] = 0;
            return false;
        } else {
            int ny = y;
            int nx = x;
            nx++;
            if (nx >= SIZE) {
                nx = 0;
                ny++;
            }
            return fillMap(ny, nx, map);
        }
    }

    private static boolean checkValid(int y, int x, int[][] map) {
        boolean[] used = new boolean[SIZE + 1];
        Arrays.fill(used,false);
        for (int i = 0; i < SIZE; i++) {
            int num = map[y][i];
            if(num == 0){
                continue;
            }
            if (!used[num]) {
                used[num] = true;
            } else {
                return false;
            }
        }

        Arrays.fill(used,false);
        for (int i = 0; i < SIZE; i++) {
            int num = map[i][x];
            if(num == 0){
                continue;
            }
            if (!used[num]) {
                used[num] = true;
            } else {
                return false;
            }
        }

        Arrays.fill(used,false);
        int ny = y / 3;
        int nx = x / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = map[3 * ny + i][3 * nx + j];
                if(num == 0){
                    continue;
                }
                if (!used[num]) {
                    used[num] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
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
        fillMap(0,0,map);
        print(map);
    }

    private static void print(int[][] map) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
