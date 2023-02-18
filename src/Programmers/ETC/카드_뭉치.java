package Programmers.ETC;

public class 카드_뭉치 {
    private static final String YES = "Yes";
    private static final String NO = "No";
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = YES;
        int index1 = 0;
        int index2 = 0;
        for(String str : goal){
            if(index1 < cards1.length && cards1[index1].equals(str)){
                index1++;
                continue;
            }
            if(index2 < cards2.length && cards2[index2].equals(str)){
                index2++;
                continue;
            }
            answer = NO;
            break;
        }
        return answer;
    }
}
