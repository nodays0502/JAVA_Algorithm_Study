package BOJ.simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_17140 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int k = stoi.apply(st.nextToken());
        int[][] map = new int[3][3];
        for(int i = 0 ; i < 3 ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < 3 ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int time = 0;

        while(map.length < n || map[0].length < m || map[n-1][m-1] != k){
            map = cal(map);
            time++;
            if(time == 1){
//                System.out.println(Arrays.deepToString(map));
            }
            if(time > 100){
                break;
            }
        }
        if(time > 100){
            System.out.println(-1);
        }else{
            System.out.println(time);
        }
    }

    private static int[][] cal(int[][] map) {
        int nLength = map.length;
        int mLength = map[0].length;
        if(nLength >= mLength) { // R 연산
//            System.out.println("R연산");
            map = rCal(map,nLength,mLength);
        }else{ // C연산
//            System.out.println("C연산");
            map = cCal(map,nLength,mLength);
        }
        return map;
    }

    private static int[][] cCal(int[][] map, int n, int m) {
        List<Integer>[] result = new ArrayList[m];
        int maxLength = 0;
        for(int i = 0 ; i < m ; i++){
            int[] cnt = new int[101];
            result[i] = new ArrayList<>();
            for(int j = 0 ; j < n ; j++){
                int num = map[j][i];
                if(num == 0){
                    continue;
                }
                if(cnt[num] == 0){
                    result[i].add(num);
                }
                cnt[num]++;
            }
            Collections.sort(result[i],(o1,o2)->{
                if(cnt[o1] == cnt[o2]){
                    return o1 - o2;
                }
                return cnt[o1] - cnt[o2];
            });
            for(int j = 0; j < result[i].size(); j++){
                int num = result[i].get(j);
                result[i].add(j+1,cnt[num]);
                j++;
            }
            maxLength = Math.max(result[i].size(),maxLength);
        }
        maxLength = Math.min(maxLength,100);
        int[][] newMap = new int[maxLength][m];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < maxLength ; j++){
                if(j < result[i].size()){
                    newMap[j][i] = result[i].get(j);
                }else{
                    newMap[j][i] = 0;
                }
            }
        }
        return newMap;
    }

    private static int[][] rCal(int[][] map, int n, int m) {
        List<Integer>[] result = new ArrayList[n];
        int maxLength = 0;
        for(int i = 0 ; i < n ; i++){
            int[] cnt = new int[101];
            result[i] = new ArrayList<>();
            for(int j = 0 ; j < m ; j++){
                int num = map[i][j];
                if(num == 0){
                    continue;
                }
                if(cnt[num] == 0){
                    result[i].add(num);
                }
                cnt[num]++;
            }
            Collections.sort(result[i],(o1,o2)->{
                if(cnt[o1] == cnt[o2]){
                    return o1 - o2;
                }
                return cnt[o1] - cnt[o2];
            });
            for(int j = 0; j < result[i].size(); j++){
                int num = result[i].get(j);
                result[i].add(j+1,cnt[num]);
                j++;
            }
            maxLength = Math.max(result[i].size(),maxLength);
        }
        maxLength = Math.min(maxLength,100);
        int[][] newMap = new int[n][maxLength];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < maxLength ; j++){
                if(j < result[i].size()){
                    newMap[i][j] = result[i].get(j);
                }else{
                    newMap[i][j] = 0;
                }
            }
        }
        return newMap;
    }
}
