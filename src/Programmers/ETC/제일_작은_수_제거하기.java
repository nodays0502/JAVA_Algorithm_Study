package Programmers.ETC;

public class 제일_작은_수_제거하기 {
    private static final int[] NOT_FOUND = {-1};
    public int[] solution(int[] arr) {


        int size = arr.length;
        if(size == 1){
            return NOT_FOUND;
        }
        int minIndex = 0;
        for(int i = 0 ; i < size ; i++){
            if(arr[minIndex] > arr[i]){
                minIndex = i;
            }
        }
        int[] answer = new int[size-1];
        boolean minNext = false;
        for(int i = 0 ; i < size ; i++){
            if(minIndex == i){
                minNext = true;
                continue;
            }
            if(!minNext){
                answer[i] = arr[i];
            }else{
                answer[i-1] = arr[i];
            }
        }
        return answer;
    }
}
