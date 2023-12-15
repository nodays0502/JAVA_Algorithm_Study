package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8911_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCnt = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCnt; t++) {
            String command = br.readLine();
            int result = cal(command);
            System.out.println(result);
        }
    }

    private static final int[] DY = {-1, 0, 1, 0};
    private static final int[] DX = {0, 1, 0, -1};
    private static final char GO = 'F';
    private static final char BACK = 'B';
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static int cal(String command) {
        int maxY = 0;
        int minY = 0;
        int maxX = 0;
        int minX = 0;
        int dir = 0;
        int y = 0;
        int x = 0;
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            if (ch == GO) {
                y += DY[dir];
                x += DX[dir];
            }
            if (ch == BACK) {
                y -= DY[dir];
                x -= DX[dir];
            }
            if (ch == LEFT) {
                dir = (dir - 1 + 4) % 4;
            }
            if (ch == RIGHT) {
                dir = (dir + 1) % 4;
            }
            maxY = Math.max(maxY, y);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            minX = Math.min(minX, x);
        }
        return (maxY - minY) * (maxX - minX);
    }

}