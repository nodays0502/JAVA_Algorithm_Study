package Programmers.ETC;

public class 광물_캐기 {

    private static String[] AX = {"diamond","iron","stone"};
    private static int[] LEVEL = {25,5,1};

    public int solution(int[] picks, String[] minerals) {
        int size = minerals.length;
        int[] intMinerals = new int[size];
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(AX[j].equals(minerals[i])){
                    intMinerals[i] = LEVEL[j];
                    break;
                }
            }
        }
        // System.out.println(Arrays.toString(intMinerals));
        int answer = dfs(0,picks,intMinerals,size);
        return answer;
    }

    private static int INF = 987654321;

    private static int dfs(int depth , int[] picks, int[] minerals, int size){
        if(depth >= size){
            return 0;
        }
        int result = INF;
        for(int i = 0 ; i < 3 ; i++){
            if(picks[i] == 0){
                continue;
            }
            int sum = 0;
            for(int j = depth ; j < Math.min(depth + 5, size) ; j++){
                sum += Math.max(1,minerals[j] / LEVEL[i]);
            }
            picks[i]--;
            result = Math.min(result, dfs(depth + 5,picks,minerals,size) + sum);
            picks[i]++;
        }
        if(result == INF){
            return 0;
        }
        return result;
    }
}
