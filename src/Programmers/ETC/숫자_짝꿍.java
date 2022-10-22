package Programmers.ETC;

public class 숫자_짝꿍 {
    private static final String NOT_FOUND = "-1";
    public String solution(String X, String Y) {
        String answer = NOT_FOUND;
        int[][] cnt = new int[2][10];
        for(int i = 0 ; i < X.length() ; i++){
            int num = Integer.parseInt(X.charAt(i)+"");
            cnt[0][num]++;
        }
        for(int i = 0 ; i < Y.length() ; i++){
            int num = Integer.parseInt(Y.charAt(i)+"");
            cnt[1][num]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9 ; i >= 0 ; i--){
            int numCnt = Math.min(cnt[0][i],cnt[1][i]);
            if(sb.length() == 0 && i == 0 && numCnt > 0){
                sb.append(0);
                break;
            }
            for(int j = 0 ; j < numCnt ; j++){
                sb.append(i);
            }
        }
        if(sb.length() > 0){
            answer = sb.toString();
        }
        return answer;
    }
}
