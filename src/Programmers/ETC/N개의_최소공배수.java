package Programmers.ETC;

public class N개의_최소공배수 {
    public int solution(int[] arr) {
        int answer = 1;
        int size = arr.length;
        int max = 0;
        for(int i = 0 ; i < size ; i++){
            max = Math.max(max,arr[i]);
        }
        for(int i = 2 ; i <= max; i++){
            int maxCnt = 0;
            for(int j = 0 ; j < size ; j++){
                int cnt = 0;
                while(arr[j] % i == 0){
                    cnt++;
                    arr[j] /= i;
                }
                maxCnt = Math.max(maxCnt,cnt);
            }
            for(int j = 0 ; j < maxCnt ; j++){
                answer *= i;
            }
        }
        return answer;
    }
}
