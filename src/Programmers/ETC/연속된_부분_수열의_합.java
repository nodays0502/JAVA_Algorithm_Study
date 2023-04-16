package Programmers.ETC;

public class 연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int startIndex = 0;
        int endIndex = -1;
        int size = sequence.length;
        int[] answer = new int[] {0,size};
        while(true){
            if(sum <= k){
                if(sum == k && answer[1] - answer[0] > endIndex - startIndex){
                    answer = new int[]{startIndex, endIndex};
                }
                endIndex++;
                if(endIndex >= size){
                    break;
                }
                sum += sequence[endIndex];
            }else{
                sum -= sequence[startIndex];
                startIndex++;
            }
        }
        return answer;
    }
}
