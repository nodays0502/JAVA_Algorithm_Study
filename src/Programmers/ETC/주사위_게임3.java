package Programmers.ETC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 주사위_게임3 {
    public int solution(int a, int b, int c, int d) {
        int answer = cal(new int[]{a,b,c,d});
        return answer;
    }
    private static int cal(int[] arr){
        Arrays.sort(arr);
        Map<Integer,Integer> cnt = new HashMap<>();
        for(int i = 0 ; i < 4 ; i++){
            cnt.merge(arr[i],1,(v1,v2)->{
                return v1+1;
            });
        }
        if(cnt.size() == 1){
            return arr[0] * 1111;
        }
        if(cnt.size() == 4){
            return arr[0];
        }
        if(cnt.size() == 3){ // 2개 같다
            int temp = 0;
            for(int num : cnt.keySet()){
                if(cnt.get(num) == 1){
                    if(temp == 0){
                        temp = num;
                    }else{
                        return temp*num;
                    }
                }
            }
        }
        if(cnt.size() == 2){
            int[] key = new int[2];
            int[] numCnt = new int[2];
            int index = 0;
            for(int num : cnt.keySet()){
                key[index] = num;
                numCnt[index++] = cnt.get(num);
            }
            if(numCnt[0] == numCnt[1]){
                return (key[0] + key[1]) * Math.abs(key[0]-key[1]);
            }
            for(int i = 0 ; i < 2; i++){
                if(numCnt[i] == 3){
                    index = i;
                }
            }
            int temp = (key[index] * 10 + key[(index+1)%2]);
            return temp*temp;
        }
        return -1;
    }
}
