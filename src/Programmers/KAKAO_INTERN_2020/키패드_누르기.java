package Programmers.KAKAO_INTERN_2020;

import java.util.HashMap;
import java.util.Map;

public class 키패드_누르기 {
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    /*
    1 2 3
    4 5 6
    7 8 9
    * 0 #
    */
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Map<Character,int[]> position = new HashMap<>();
        position = init();
        char userDir = LEFT;
        if("right".equals(hand)){
            userDir = RIGHT;
        }
        int[] left = position.get('*');
        int[] right = position.get('*');
        StringBuilder sb = new StringBuilder();
        for(int num : numbers){
            char now = (char)('0' + num);
            int[] numberPosition = position.get(now);
            if(now == '1' || now == '4' || now == '7'){
                left = numberPosition;
                sb.append(LEFT);
                continue;
            }
            if(now == '3' || now == '6' || now == '9'){
                right = numberPosition;
                sb.append(RIGHT);
                continue;
            }
            int leftDistance = calDistance(left,numberPosition);
            int rightDistance = calDistance(right,numberPosition);
            if( (leftDistance == rightDistance && userDir == LEFT) ||
                leftDistance < rightDistance){
                sb.append(LEFT);
                left = numberPosition;
                continue;
            }
            sb.append(RIGHT);
            right = numberPosition;
        }
        answer = sb.toString();
        return answer;
    }
    private int calDistance(int[] hand, int[] target){
        return Math.abs(hand[0] - target[0]) + Math.abs(hand[1] - target[1]);
    }
    private Map<Character,int[]> init(){
        Map<Character,int[]> position = new HashMap<>();
        position.put('1',new int[] {0,0});
        position.put('2',new int[] {0,1});
        position.put('3',new int[] {0,2});
        position.put('4',new int[] {1,0});
        position.put('5',new int[] {1,1});
        position.put('6',new int[] {1,2});
        position.put('7',new int[] {2,0});
        position.put('8',new int[] {2,1});
        position.put('9',new int[] {2,2});
        position.put('*',new int[] {3,0});
        position.put('0',new int[] {3,1});
        position.put('#',new int[] {3,2});
        return position;
    }
}
