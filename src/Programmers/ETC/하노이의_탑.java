package Programmers.ETC;

public class 하노이의_탑 {
    public int[][] solution(int n) {
        int[][] answer = {};
        List<int[]> result = new ArrayList<>();
        hanoi(n,1,2,3,result);
        answer = new int[result.size()][];
        for(int i = 0 ; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
    private void hanoi(int depth, int from,int temp,int to,List<int[]> result){
        if(depth == 0){
            return ;
        }
        hanoi(depth-1,from,to,temp,result);
        result.add(new int[] {from,to});
        // System.out.println(from+"->"+to);
        hanoi(depth-1,temp,from,to,result);
    }
}
