package Programmers.ETC;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 단어_변환 {
    public int solution(String begin, String target, String[] words) {
        Set<String> set = new HashSet<>();
        for(String word : words){
            set.add(word);
        }
        int answer = bfs(begin,target,set);
        return answer;
    }
    private int bfs(String begin,String end, Set<String> set){
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(begin);
        q.offer(begin);
        int time = 0;
        int size = begin.length();
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int s = 0 ; s < qSize ; s++){
                String now = q.poll();
                if(end.equals(now)){
                    return time;
                }

                for(String str : set){
                    int cnt = 0;
                    for(int i = 0 ; i < size ; i++){
                        if(str.charAt(i) != now.charAt(i)){
                            cnt++;
                        }
                    }
                    if(cnt == 1 && !visited.contains(str)){
                        q.offer(str);
                        visited.add(str);
                    }
                }
            }
            time++;
        }
        return 0;
    }
}
