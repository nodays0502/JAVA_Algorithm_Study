package Programmers.ETC;

public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int size = str.length();
        int[] answer = new int[size];
        for(int i = 0 ; i < size; i++){
            answer[i] = str.charAt(size-i-1) - '0';
        }
        return answer;
    }
}
