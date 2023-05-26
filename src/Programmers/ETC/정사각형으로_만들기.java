package Programmers.ETC;

public class 정사각형으로_만들기 {
    private static final int EMPTY = 0;
    public int[][] solution(int[][] arr) {
        int size = arr.length;
        for(int i = 0 ; i < arr.length ; i++){
            size = Math.max(size,arr[i].length);
        }
        int[][] answer = new int[size][size];
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(arr.length <= i){
                    answer[i][j] = EMPTY;
                    continue;
                }
                if(arr[i].length <= j){
                    answer[i][j] = EMPTY;
                    continue;
                }
                answer[i][j] = arr[i][j];
            }
        }

        return answer;
    }
}
