package Programmers.ETC;

public class 가장_큰_수_찾기 {
    public int[] solution(int[] array) {
        int[] answer = {};
        int maxIndex = 0;
        int maxValue = 0;
        for(int i = 0 ; i < array.length ; i++){
            if(maxValue < array[i]){
                maxIndex = i;
                maxValue = array[i];
            }
        }
        answer = new int[] {maxValue,maxIndex};
        return answer;
    }
}
