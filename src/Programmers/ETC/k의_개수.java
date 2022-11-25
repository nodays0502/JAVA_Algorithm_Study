package Programmers.ETC;

public class k의_개수 {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(;i<=j;i++){
            answer += count(i,k);
        }
        return answer;
    }
    private int count(int num, int k){
        int cnt = 0;
        while(true){
            if(num % 10 == k){
                cnt++;
            }
            num /= 10;
            if(num == 0){
                break;
            }
        }
        return cnt;
    }
}
