package Programmers.ETC;

public class 배열_뒤집기 {
    public int[] solution(int[] num_list) {
        int size = num_list.length;
        int[] answer = new int[size];
        for(int i = 0 ; i < size ; i++){
            answer[i] = num_list[size - i - 1];
        }
        return answer;
    }
}
