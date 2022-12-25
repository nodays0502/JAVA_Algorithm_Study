package Programmers.ETC;

public class n의_배수_고르기 {
    public int[] solution(int n, int[] numlist) {
        int[] answer = {};
        List<Integer> list = new LinkedList<>();
        for(int num : numlist){
            if(num % n == 0){
                list.add(num);
            }
        }
        answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
