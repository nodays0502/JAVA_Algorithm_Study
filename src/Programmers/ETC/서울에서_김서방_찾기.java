package Programmers.ETC;

public class 서울에서_김서방_찾기 {
    private static final String KIM = "Kim";
    public String solution(String[] seoul) {
        String answer = "";
        int index = 0;
        for(int i = 0 ; i < seoul.length ; i++){
            if(KIM.equals(seoul[i])){
                index = i;
                break;
            }
        }
        answer = "김서방은 "+index+"에 있다";
        return answer;
    }
}
