package Programmers.ETC;

public class 점_찍기 {
    public long solution(int k, int d) {
        long answer = 0;
        long standard = (long)d * d;
        for(int i = 0 ; i <= d  ; i += k ){
            long length = i;
            long tempLength = length * length;
            long cnt = ((long)Math.sqrt(standard - tempLength)) / k + 1;
            // System.out.println(length + " " + cnt);
            answer += cnt;
        }
        return answer;
    }
}
