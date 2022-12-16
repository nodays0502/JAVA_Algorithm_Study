package Programmers.ETC;

public class A로_B_만들기 {
    private static final int SIZE = 26;
    private static final int TRUE = 1;
    private static final int FALSE = 0;
    public int solution(String before, String after) {
        int answer = TRUE;
        int[] cnt = new int[SIZE];
        for(int i = 0 ; i < before.length() ; i++){
            char ch = before.charAt(i);
            int index = ch-'a';
            cnt[index]++;
        }
        for(int i = 0 ; i < after.length() ; i++){
            char ch = after.charAt(i);
            int index = ch-'a';
            cnt[index]--;
            if(cnt[index] < 0){
                answer = FALSE;
            }
        }
        return answer;
    }
}
