package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_18808 {

    private static final int EMPTY = 0;
    private static final int BLOCK = 1;
    private static final int[] NOT_FOUND = {-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        List<int[][]> stickers = new ArrayList<>();
        for (int s = 0; s < k; s++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken());
            int b = stoi.apply(st.nextToken());
            int[][] sticker = new int[a][b];
            for (int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < b; j++) {
                    sticker[i][j] = stoi.apply(st.nextToken());
                }
            }
            stickers.add(sticker);
        }
        int result = cal(0, n, m, stickers);
        System.out.println(result);

    }

    private static int cal(int depth, int n, int m, List<int[][]> stickers) {
        int[][] map = new int[n][m];
        for (int[][] sticker : stickers) {
            int[][] nowSticker = sticker;
            for(int i = 0 ; i < 4 ; i++){
                int[] location = findLocation(nowSticker,map,n,m);
                if(location != NOT_FOUND){

                    append(location[0],location[1],map, nowSticker);
                    break;
                }
                nowSticker = rotation(nowSticker);
            }
        }
        return countMap(map,n,m);
    }

    private static int countMap(int[][] map, int n, int m) {
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == BLOCK){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static int[] findLocation(int[][] sticker, int[][] map, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canAppend(i, j, map, sticker, n, m)) {
                    return new int[]{i,j};
                }
            }
        }
        return NOT_FOUND;
    }

    private static void append(int y, int x, int[][] map, int[][] sticker) {
        int stickerMaxY = sticker.length;
        int stickerMaxX = sticker[0].length;
        for (int i = 0; i < stickerMaxY; i++) {
            for (int j = 0; j < stickerMaxX; j++) {
                map[y+i][x+j] += sticker[i][j];
            }
        }
    }

    private static boolean canAppend(int y, int x, int[][] map, int[][] sticker, int n, int m) {
        int stickerMaxY = sticker.length;
        int stickerMaxX = sticker[0].length;
        if (y + stickerMaxY > n || x + stickerMaxX > m) {
            return false;
        }
        for (int i = 0; i < stickerMaxY; i++) {
            for (int j = 0; j < stickerMaxX; j++) {
                if (map[y+i][x+j] + sticker[i][j] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] rotation(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][i] = arr[n - i - 1][j];
            }
        }
        return temp;
    }

}
