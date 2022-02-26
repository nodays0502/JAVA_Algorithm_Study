package Programmers.DevMatching_2021;

import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매 {
    private static void initEnroll(String[] enroll,Map<String,Integer> map){
        int index = 0;
        for(String str : enroll){
            map.put(str,index++);
        }
    }
    private static void initReferral(String[] referral,
        int[] parent,
        Map<String,Integer> map){
        int index = 0;
        for(String str : referral){
            if("-".equals(str)){
                parent[index++] = -1;
            }else{
                int parentIndex = map.get(str);
                parent[index++] = parentIndex;
            }
        }
    }
    private static void calMoney(int[] answer,
        int[] parent,
        int nowIndex,
        int money){
        if(nowIndex == -1){
            return ;
        }
        answer[nowIndex] += money - money/10;
        calMoney(answer,parent,parent[nowIndex],money / 10);
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String,Integer> map = new HashMap<>();
        initEnroll(enroll,map);
        int[] parent = new int[enroll.length];
        initReferral(referral,parent,map);
        // System.out.println(Arrays.toString(parent));
        for(int i = 0 ; i < seller.length ; i++){
            int nowIndex = map.get(seller[i]);
            calMoney(answer,parent,nowIndex,amount[i]*100);
        }
        return answer;
    }
}
