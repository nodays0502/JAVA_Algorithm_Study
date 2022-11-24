package Programmers.ETC;

public class 짝수_홀수_개수 {
    private static final int ODD_INDEX = 0;
    private static final int EVEN_INDEX = 1;
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for(int num : num_list){
            if(num % 2 == 0){
                answer[ODD_INDEX]++;
            }else{
                answer[EVEN_INDEX]++;
            }
        }
        return answer;
    }
}
