package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_21608_2 {
    private static int[] SCORE = {0,1,10,100,1000};
    private static int[] dy = {-1,0,1,0};
    private static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[][] map = new int[n][n];
        Map<Integer, Set<Integer>> likeStudent = new HashMap<>();
        for(int i = 0 ; i < n * n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            int student = stoi.apply(st.nextToken());
            likeStudent.put(student,new HashSet<>());
            for(int j = 0 ; j < 4; j++){
                int num = stoi.apply(st.nextToken());
                likeStudent.get(student).add(num);
            }
//            System.out.println(student);
            shitDown(map,student,likeStudent,n);
        }
        int result = calScore(map,likeStudent,n);
        System.out.println(result);
    }

    private static int calScore(int[][] map, Map<Integer, Set<Integer>> likeStudent, int n) {
        int totalScore = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int likeCnt = 0;
                for(int dir = 0  ; dir < 4; dir++){
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if(!checkBound(ny,nx,n)){
                        continue;
                    }
                    if(likeStudent.get(map[i][j]).contains(map[ny][nx])){
                        likeCnt++;
                    }
                }
                totalScore += SCORE[likeCnt];
            }
        }
        return totalScore;
    }

    private static void shitDown(int[][] map , int studentNum,Map<Integer, Set<Integer>> likeStudent, int n){
        int[] result = new int[] {-1,-1};
        int[] resultPosition = new int[] {0,0};
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] != EMPTY){
                    continue;
                }
                int[] temp = checkScore(i,j,map,studentNum,likeStudent,n);
                if(result[0] < temp[0]){
                    result = temp;
                    resultPosition = new int[]{i,j};
                    continue;
                }
                if(result[0] == temp[0] && result[1] < temp[1]){
                    result = temp;
                    resultPosition = new int[]{i,j};
                    continue;
                }
            }
        }
        map[resultPosition[0]][resultPosition[1]] = studentNum;
    }
    private static final int EMPTY = 0;
    private static int[] checkScore(int y, int x, int[][] map, int studentNum, Map<Integer, Set<Integer>> likeStudent, int n) {
        int likeCnt = 0;
        int emptyCnt = 0;
        for(int dir = 0 ; dir < 4 ;dir++){
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(!checkBound(ny,nx,n)){
                continue;
            }
            if(map[ny][nx] == EMPTY){
                emptyCnt++;
            }
            if(likeStudent.get(studentNum).contains(map[ny][nx])){
                likeCnt++;
            }
        }
        return new int[] {likeCnt,emptyCnt};
    }

    private static boolean checkBound(int y, int x, int n){
        if(y >= 0 && y < n && x >= 0 && x < n){
            return true;
        }
        return false;
    }
}
