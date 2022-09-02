package Programmers.KAKAO_INTERN_2022;

public class 두_큐_합_같게_만들기 {
    private static  final int FAIL = -1;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long totalSum = 0;
        int size = queue1.length;
        long sum = 0;
        int[] totalQueue = new int[2 * size];
        for(int i = 0 ; i < size ; i++){
            totalSum += queue1[i] + queue2[i];
            sum += queue1[i];
            totalQueue[i] = queue1[i];
            totalQueue[size + i] = queue2[i];
        }
        if(totalSum % 2 != 0){
            return FAIL;
        }
        int si = 0;
        int ei = size;
        while(true){
            if(sum == totalSum / 2){
                return answer;
            }else if(sum < totalSum / 2){
                if(ei >= 2*size){
                    break;
                }
                sum += totalQueue[ei++];
            }else{
                sum -= totalQueue[si++];
            }
            answer++;
        }
        return FAIL;
    }
}
