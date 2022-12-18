package Programmers.ETC;

public class 배열_회전시키기 {
    private static final String RIGHT = "right";
    private static final String LEFT = "left";
    public int[] solution(int[] numbers, String direction) {
        int size = numbers.length;
        int[] answer = new int[size];
        int dir = 0;
        if(RIGHT.equals(direction)){
            dir = -1;
        }else{
            dir = 1;
        }
        for(int i = 0 ; i < size ; i++){
            int index = i + dir;
            if(index < 0){
                index += size;
            }
            if(index >= size){
                index -= size;
            }
            answer[i] = numbers[index];
        }
        return answer;
    }
}
