package Programmers.ETC;

public class 종이_자르기 {
    public int solution(int M, int N) {
        int answer = 0;
        int temp = N - 1;
        answer += temp + N * (M-1);
        return answer;
    }
}
