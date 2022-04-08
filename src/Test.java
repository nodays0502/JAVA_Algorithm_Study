import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {

    public static void main(String[] args) throws IOException {
        int arr[][] = new int[3][3];
        int num = 1;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                arr[i][j] = num++;
            }
        }
        arr = rotate(arr);
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static int[][] rotate(int[][] m) {
        int N = m.length;
        int M = m[0].length;
        // 돌린 크기만큼으로 생성해준다.
        int[][] copyMap = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[N - 1 - j][i] = m[i][j];
            }
        }

        // 새로 돌린 배열로 반환해준다.
        return copyMap;
    }
}