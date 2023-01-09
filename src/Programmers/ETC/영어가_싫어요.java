package Programmers.ETC;

public class 영어가_싫어요 {
    private static final String[] NUMBER = {
        "zero", "one", "two",
        "three", "four", "five",
        "six", "seven", "eight",
        "nine"
    };
    public long solution(String numbers) {
        long answer = 0;
        int size = numbers.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < size ; ){
            for(int j = 0 ; j < NUMBER.length ; j++){
                boolean flag = true;
                for(int k = 0 ; k < NUMBER[j].length() ; k++){
                    if(NUMBER[j].charAt(k) != numbers.charAt(i + k)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    i += NUMBER[j].length();
                    sb.append(j);
                    break;
                }
            }
        }
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
