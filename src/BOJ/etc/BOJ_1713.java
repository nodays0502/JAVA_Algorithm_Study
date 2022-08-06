package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1713 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int studentCnt = Integer.parseInt(br.readLine());
        int[] recommends = new int[studentCnt];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < studentCnt ; i++){
            recommends[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = cal(recommends,n,studentCnt);
        for(int num : result){
            System.out.print(num+" ");
        }
    }

    private static final int INF = 987654321;
    private static int[] cal(int[] recommends, int n, int studentCnt) {

        Map<Integer,Integer> recommendCnt = new HashMap<>();
        Map<Integer,Integer> time = new HashMap<>();
        for(int i = 0 ; i < studentCnt ; i++){
            int recommend = recommends[i];
            int nowCnt = recommendCnt.getOrDefault(recommend,0);
            nowCnt++;
            if(!time.containsKey(recommend) && time.size() > n - 1){
                int deleteKey = -1;
                int deleteCnt = INF;
                for(int key : time.keySet()){
                    int keyCnt = recommendCnt.get(key);
                    if(deleteCnt > keyCnt){
                        deleteKey = key;
                        deleteCnt = keyCnt;
                    }else if(deleteCnt == keyCnt && time.get(deleteKey) > time.get(key)){
                        deleteKey = key;
                        deleteCnt = keyCnt;
                    }
                }
                recommendCnt.remove(deleteKey);
                time.remove(deleteKey);
            }
            recommendCnt.put(recommend,nowCnt);
            if(!time.containsKey(recommend)){
                time.put(recommend,i);
            }
        }
        int index = 0;
        int[] result = new int[time.size()];
        for(int key : time.keySet()){
            result[index++] = key;
        }
        Arrays.sort(result);
        return result;
    }
}
