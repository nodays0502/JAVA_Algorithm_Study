package Programmers.ETC;

public class 수열과_구간_쿼리2 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        // Arrays.sort(arr);
        for(int i = 0 ; i < queries.length ; i++){
            int result = -1;
            for(int j = queries[i][0] ; j <= queries[i][1] ; j++){

                if(queries[i][2] < arr[j]){
                    if(result == -1){
                        result = arr[j];
                    }
                    result = Math.min(result,arr[j]);
                }
            }
            answer[i] = result;
        }
        return answer;
    }
}
