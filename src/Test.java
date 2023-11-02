import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Test {

    private static final char WHITE = 'W';
    private static final char RED = 'R';
    private static final char BLUE = 'B';
    private static final char GREEN = 'G';
    private static final char YELLOW = 'Y';
    private static final char[] COLOR = {'R', 'B', 'G', 'Y', 'W'};
    private static final int[] COLOR_VALUE = {7, 5, 3, 2, 0};
    private static final int SIZE = 5;
    private static final int INGREDIENT_SIZE = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] mapValue = new int[SIZE][SIZE];
        char[][] mapColor = new char[SIZE][SIZE];
        int[][][] ingredientValue = new int[n][INGREDIENT_SIZE][INGREDIENT_SIZE];
        char[][][] ingredientColor = new char[n][INGREDIENT_SIZE][INGREDIENT_SIZE];
        for (int s = 0; s < n; s++) {
            for (int i = 0; i < INGREDIENT_SIZE; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < INGREDIENT_SIZE; j++) {
                    ingredientValue[s][i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < INGREDIENT_SIZE; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < INGREDIENT_SIZE; j++) {
                    ingredientColor[s][i][j] = st.nextToken().charAt(0);
                }
            }
        }
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(mapValue[i], 0);
            Arrays.fill(mapColor[i], WHITE);
        }
        boolean[] used = new boolean[n];
        int result = cal(0, used,mapValue, mapColor, ingredientValue, ingredientColor, n);
        System.out.println(result);
    }

    private static int cal(int depth, boolean[] used, int[][] mapValue, char[][] mapColor,
        int[][][] ingredientValue, char[][][] ingredientColor, int n) {
        if (depth == 3) {
            return calTotalValue(mapValue, mapColor);
        }
        int result = 0;
        for (int index = 0; index < n; index++) {
            if(used[index]){
                continue;
            }
            for (int r = 0; r < 4; r++) {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        int[][] nextMapValue = addIngredientValue(i, j, mapValue,
                            ingredientValue[index]);
                        char[][] nextMapColor = addIngredientColor(i, j, mapColor,
                            ingredientColor[index]);
                        used[index] = true;
                        result = Math.max(result,
                            cal(depth + 1, used, nextMapValue, nextMapColor, ingredientValue,
                                ingredientColor, n));
                        used[index] = false;
                    }
                }
                mapValue = rotationValue(mapValue);
                mapColor = rotationColor(mapColor);
            }
        }
        return result;
    }

    private static int[][] rotationValue(int[][] mapValue) {
        int[][] result = new int[SIZE][SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                result[j][i] = mapValue[SIZE-i-1][j];
            }
        }
        return result;
    }
    private static char[][] rotationColor(char[][] mapColor) {
        char[][] result = new char[SIZE][SIZE];
        for(int i = 0 ; i < SIZE ; i++){
            for(int j = 0 ; j < SIZE ; j++){
                result[j][i] = mapColor[SIZE-i-1][j];
            }
        }
        return result;
    }
    private static int calTotalValue(int[][] mapValue, char[][] mapColor) {
        int[] colorCnt = new int[COLOR.length];
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < COLOR.length; i++) {
            index.put(COLOR[i], i);
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int nowColor = index.get(mapColor[i][j]);
                colorCnt[nowColor] += mapValue[i][j];
            }
        }
//        System.out.println(Arrays.toString(colorCnt));
        int result = 0;
        for (int i = 0; i < COLOR.length; i++) {
            result += COLOR_VALUE[i] * colorCnt[i];
        }
        return result;
    }

    private static char[][] addIngredientColor(int y, int x, char[][] mapColor,
        char[][] ingredientColor) {
        char[][] result = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = mapColor[i][j];
            }
        }
        for (int i = 0; i < INGREDIENT_SIZE; i++) {
            for (int j = 0; j < INGREDIENT_SIZE; j++) {
                if (ingredientColor[i][j] != WHITE) {
                    result[y + i][x + j] = ingredientColor[i][j];
                }
            }
        }
        return result;
    }

    private static int[][] addIngredientValue(int y, int x, int[][] mapValue,
        int[][] ingredientValue) {
        int[][] result = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = mapValue[i][j];
            }
        }
        for (int i = 0; i < INGREDIENT_SIZE; i++) {
            for (int j = 0; j < INGREDIENT_SIZE; j++) {
                result[y + i][x + j] = mapValue[y + i][x + j] + ingredientValue[i][j];
                if (result[y + i][x + j] < 0) {
                    result[y + i][x + j] = 0;
                }
                if (result[y + i][x + j] > 9) {
                    result[y + i][x + j] = 9;
                }
            }
        }
        return result;
    }
}