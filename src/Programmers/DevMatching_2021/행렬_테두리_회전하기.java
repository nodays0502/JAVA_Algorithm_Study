package Programmers.DevMatching_2021;

public class 행렬_테두리_회전하기 {
    private static int[][] init(int n,int m){
        int[][] arr = new int[n][m];
        int num = 1;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                arr[i][j] = num++;
            }
        }
        return arr;
    }
    private static int[] dy = {0,1,0,-1};
    private static int[] dx = {1,0,-1,0};
    private static int rotation(int y1,int x1,int y2,int x2,int[][] arr){
        int ny = y1 - 1;
        int nx = x1 - 1;
        int prev = arr[ny][nx];
        int result = prev;
        for(int i = 0 ; i < 4; i++){
            ny += dy[i];
            nx += dx[i];
            while(nx >= x1-1 && nx <= x2-1
                && ny >= y1-1 && ny <= y2-1){
                int temp = arr[ny][nx];
                arr[ny][nx] = prev;
                prev = temp;
                result = Math.min(prev,result);
                ny += dy[i];
                nx += dx[i];
            }
            ny -= dy[i];
            nx -= dx[i];
        }
        return result;
    }
    private static void print(int n , int m , int[][] arr){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = init(rows,columns);
        int index = 0;
        for(int[] query : queries ){
            answer[index++] = rotation(query[0],query[1],query[2],query[3],arr);
            // print(rows,columns,arr);
        }
        return answer;
    }
}
