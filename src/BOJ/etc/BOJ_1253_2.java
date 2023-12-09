package BOJ.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1253_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[n];
        for(int i = 0 ; i < n ; i++){
            num[i] =  Integer.parseInt(st.nextToken());
        }
        int result = cal(num,n);
        System.out.println(result);
    }

    private static int cal(int[] num, int n) {
//        Arrays.sort(num);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.merge(num[i],1,(v1,v2)->{
                return v1+1;
            });
        }
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == j){
                    continue;
                }
                int tempNum = num[i] - num[j];
                if(map.containsKey(tempNum)){
                    int tempCnt = map.get(tempNum);
                    if(num[i] == tempNum){
                        tempCnt--;
                    }
                    if(num[j] == tempNum){
                        tempCnt--;
                    }
                    if(tempCnt > 0){
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }
