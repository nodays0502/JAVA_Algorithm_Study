package Programmers.ETC;

public class 쿼드압축_후_개수_세기 {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        divideArea(0,0,arr.length,arr,answer);
        return answer;
    }
    private boolean checkSame(int y,int x,int length, int[][] arr){
        int num = arr[y][x];
        for(int i = y ; i < y+length ; i++){
            for(int j = x ; j < x+length ; j++){
                if(num != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    private static final int ONE = 1;
    private static final int ZERO = 0;

    private void divideArea(int y,int x,int length,int[][] arr,int[] result){
        if(checkSame(y,x,length,arr)){
            if(arr[y][x] == ONE){
                result[ONE]++;
            }else{
                result[ZERO]++;
            }
            return ;
        }
        int nextLength = length / 2;
        for(int i = 0 ; i < 2; i++){
            for(int j = 0 ; j < 2; j++){
                divideArea(y +i *nextLength, x +j *nextLength, nextLength, arr, result);
            }
        }
    }
}
