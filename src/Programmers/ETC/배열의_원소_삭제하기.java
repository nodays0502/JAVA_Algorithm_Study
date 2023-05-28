package Programmers.ETC;

public class 배열의_원소_삭제하기 {
    public int[] solution(int[] arr, int[] delete_list) {
        int size = arr.length;
        boolean[] isDeleted = new boolean[size];
        int resultSize = size;
        for(int num : delete_list){
            for(int i = 0 ; i < size ; i++){
                if(arr[i] == num){
                    isDeleted[i] = true;
                    resultSize--;
                    break;

                }
            }
        }
        int[] answer = new int[resultSize];
        int index = 0;
        for(int i = 0 ; i < size ; i++){
            if(!isDeleted[i]){
                answer[index++] = arr[i];
            }
        }

        return answer;
    }
}
