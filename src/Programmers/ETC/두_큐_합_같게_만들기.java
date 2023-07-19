package Programmers.ETC;

public class 두_큐_합_같게_만들기 {
    private static final int NOT_FOUND = -1;
    public int solution(int[] queue1, int[] queue2) {

        long sum = 0;
        int size = queue1.length;
        for(int i = 0 ; i < size ; i++){
            sum += queue1[i] + queue2[i];
        }
        if(sum % 2 != 0){
            return NOT_FOUND;
        }
        long halfSum = sum / 2;
        int totalSize = 2*size;
        int[] totalQueue = new int[totalSize];
        sum = 0;
        for(int i = 0 ; i < size ; i++){
            totalQueue[i] = queue1[i];
            sum += queue1[i];
            totalQueue[size + i] = queue2[i];
        }
        int startIndex = 0;
        int endIndex = size;
        int answer = 0;
        while(true){
            if(sum == halfSum){
                break;
            }
            if(sum < halfSum){
                if(endIndex >= totalSize){
                    return NOT_FOUND;
                }
                sum += totalQueue[endIndex++];
                answer++;
                continue;
            }
            if(sum > halfSum){
                sum -= totalQueue[startIndex++];
                answer++;
                continue;
            }
            answer++;
        }
        return answer;
    }
}
