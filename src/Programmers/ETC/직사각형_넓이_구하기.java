package Programmers.ETC;

public class 직사각형_넓이_구하기 {
    private static final int NOT_VALID = -555;
    public int solution(int[][] dots) {
        int answer = 0;
        int yLength = 0;
        int xLength = 0;
        int y = NOT_VALID;
        int x = NOT_VALID;
        for(int[] dot : dots){
            if(y == NOT_VALID){
                y = dot[0];
            }else if(dot[0] != y){
                yLength = Math.abs(y - dot[0]);
            }
            if(x == NOT_VALID){
                x = dot[1];
            }else if(dot[1] != x){
                xLength = Math.abs(x - dot[1]);
            }
        }
        answer = yLength * xLength;
        return answer;
    }
}
