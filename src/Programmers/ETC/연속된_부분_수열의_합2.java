package Programmers.ETC;

public class 연속된_부분_수열의_합2 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = null;
        int size = sequence.length;
        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;

        while(true){
            if(sum < k){
                if(endIndex >= size){
                    break;
                }
                sum += sequence[endIndex];
                endIndex++;
            }else {
                if(sum == k && (answer == null || endIndex-1 - startIndex < answer[1] - answer[0]) ){
                    answer = new int[]{startIndex, endIndex-1};
                }
                sum -= sequence[startIndex];
                startIndex++;
            }
        }
        return answer;
    }
}
