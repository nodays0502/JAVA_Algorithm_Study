import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

    private static final int N_SIZE = 6;
    private static final int M_SIZE = 3;
    private static final int TEST_CNT = 4;
    private static final int CAN = 1;
    private static final int CAN_T = 0;
    private static final int WIN_INDEX = 0;
    private static final int DRAW_INDEX = 1;
    private static final int LOSE_INDEX = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] score = new int[N_SIZE][4 * M_SIZE];
        StringTokenizer st;
        for (int t = 0; t < TEST_CNT; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N_SIZE; i++) {
                for (int j = 0; j < M_SIZE; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if (canScore(score)) {
                System.out.print(CAN + " ");
            } else {
                System.out.print(CAN_T + " ");
            }
        }

    }

    private static boolean canScore(int[][] score) {
        int winCnt = 0;
        int drawCnt = 0;
        int loseCnt = 0;
        for (int i = 0; i < N_SIZE; i++) {
            winCnt += score[i][WIN_INDEX];
        }
        for (int i = 0; i < N_SIZE; i++) {
            drawCnt += score[i][DRAW_INDEX];
        }
        for (int i = 0; i < N_SIZE; i++) {
            loseCnt += score[i][LOSE_INDEX];
        }

        // 무승부 , 승 패 개수가 맞지 않을 때
        if (drawCnt % 2 != 0 || winCnt != loseCnt || winCnt + drawCnt + loseCnt != 30) {
            return false;
        }

        // 한명이 무승부 개수의 반 이상인 경우
        for (int i = 0; i < N_SIZE; i++) {
            if (2 * score[i][DRAW_INDEX] > drawCnt) {
                return false;
            }
        }
        // 승 무 패 합이 5가 안되는 경우
        for (int i = 0; i < N_SIZE; i++) {
            if (score[i][WIN_INDEX] + score[i][DRAW_INDEX] + score[i][LOSE_INDEX] != 5) {
                return false;
            }
        }
        return true;
    }

}