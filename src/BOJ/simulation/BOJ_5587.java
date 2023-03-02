package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class BOJ_5587 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        int[][] input = new int[2][n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            input[0][i] = stoi.apply(br.readLine());
            set.add(input[0][i]);
        }
        Arrays.sort(input[0]);
        int index = 0;
        for (int i = 1; i <= 2 * n; i++) {
            if (!set.contains(i)) {
                input[1][index++] = i;
            }
        }
        cal(input, n);
    }

    private static void cal(int[][] input, int n) {
        boolean[][] used = new boolean[2][n];
        int index1 = 0;
        int index2 = 0;
        int number = 0;
        while (true) {
            if(isFinish(used,n)){
                break;
            }
            while (index1 < n && (number > input[0][index1] || used[0][index1]) ) {
                index1++;
            }
            if(index1 >= n){
                number = 0;
                index1 = 0;
                index2 = 0;
                while (index2 < n && (used[1][index2] && used[1][index2]) ) {
                    index2++;
                }
            }else{
                used[0][index1] = true;
                number = input[0][index1];
            }
            if(isFinish(used,n)){
                break;
            }
            while (index2 < n && (number > input[1][index2] || used[1][index2]) ) {
                index2++;
            }
            if(index2 >= n){
                number = 0;
                index1 = 0;
                index2 = 0;
                while (index1 < n && (used[0][index1] || used[0][index1]) ) {
                    index1++;
                }
            }else{
                used[1][index2] = true;
                number = input[1][index2];
            }
        }
        int[] cnt = new int[2];
        for (int i = 0; i < n; i++) {
            if (!used[0][i]) {
                cnt[0]++;
            }
            if (!used[1][i]) {
                cnt[1]++;
            }
        }
        System.out.println(cnt[1]);
        System.out.println(cnt[0]);
    }

    private static boolean isFinish(boolean[][] used,int n) {
        boolean[] finish = new boolean[2];
        Arrays.fill(finish,true);
        for(int i = 0 ; i < n ; i++){
            if(!used[0][i]){
                finish[0] = false;
            }
            if(!used[1][i]){
                finish[1] = false;
            }
        }
        return finish[0] | finish[1];
    }
}
