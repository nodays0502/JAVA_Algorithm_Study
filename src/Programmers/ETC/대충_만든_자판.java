package Programmers.ETC;

public class 대충_만든_자판 {
    private static final int NOT_FOUND = 102;
    public int[] solution(String[] keymap, String[] targets) {
        int size = targets.length;
        int[] answer = new int[size];
        for(int i = 0 ; i < size ; i++){
            String target = targets[i];
            int result = 0;
            for(int j = 0 ; j < target.length() ; j++){
                int index = NOT_FOUND;
                for(String str : keymap){
                    int tempIndex = str.indexOf(target.charAt(j));
                    if(tempIndex == -1){
                        continue;
                    }
                    index = Math.min(index,tempIndex+1);
                }
                if(index == NOT_FOUND){
                    result = -1;
                    break;
                }
                result += index;
            }
            answer[i] = result;

        }
        return answer;
    }
}
