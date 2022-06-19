package Programmers.ETC;

public class 숫자의_표현 {
    public int solution(int n) {
        int answer = countSumCnt(n);
        return answer;
    }
    private int countSumCnt(int n){
        int sum = 0;
        int si = 0;
        int ei = 0;
        int result = 0;
        while(ei <= n){
            if(sum < n){
                sum += ++ei;
            }else if(sum == n){
                result++;
                sum -= ++si;
            }else{ // sum > n
                sum -= ++si;
            }
        }
        return result;
    }
}
