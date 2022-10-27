package Programmers.ETC;

public class 옹알이_2 {
    private static final String[] WORD = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling){
            prevIndex = -1;
            if(detect(str)){
                answer++;
            }
        }
        return answer;
    }
    private static int prevIndex = -1;
    private boolean detect(String str){
        int index = 0;
        while(true){
            if(index >= str.length()){
                return true;
            }
            int temp = cal(str,index);
            if(temp > 0){
                index += temp;
            }else{
                break;
            }
        }
        return false;
    }
    private int cal(String str,int index){
        for(int i = 0 ; i < WORD.length ; i++){
            boolean flag = true;
            if(index + WORD[i].length() > str.length()){
                continue;
            }
            for(int j = 0 ; j < WORD[i].length(); j++){
                if(WORD[i].charAt(j) == str.charAt(index+j)){

                }else{
                    flag = false;
                    break;
                }
            }
            if(flag && prevIndex == i){
                continue;
            }
            if(flag){
                prevIndex = i;
                return WORD[i].length();
            }
        }
        return -1;
    }
}
