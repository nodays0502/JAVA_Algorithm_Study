package Programmers.ETC;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기 {
    public int solution(String numbers) {
        int answer = 0;
        int size = numbers.length();
        int[] num = new int[size];
        for(int i = 0 ; i < size ; i++){
            num[i] = Integer.parseInt(numbers.charAt(i)+"");
        }
        boolean[] used = new boolean[size];
        Set<Integer> prime = new HashSet<>();
        dfs(0,0,used,num,size,prime);
        answer = prime.size();
        return answer;
    }
    private void dfs(int depth,int now,boolean[]used,int[] num,int size, Set<Integer> prime){
        if(checkIsPrime(now)){
            prime.add(now);
        }
        if(depth == size){
            return ;
        }
        for(int i = 0 ; i < size ; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            dfs(depth+1,10*now +num[i],used,num,size,prime);
            used[i] = false;
        }
    }
    private boolean checkIsPrime(int num){
        if(num == 1 || num == 0){
            return false;
        }
        for(int i = 2 ; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
