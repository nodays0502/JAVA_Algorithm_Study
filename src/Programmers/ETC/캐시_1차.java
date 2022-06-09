package Programmers.ETC;

import java.util.HashMap;
import java.util.Map;

public class 캐시_1차 {
    private static final int CACHE_HIT_TIME = 1;
    private static final int CACHE_MISS_TIME = 5;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String,Integer> cache = new HashMap<>();
        int prevIndex = 0;
        for(int i = 0 ; i < cities.length ; i++){
            String now = cities[i].toUpperCase();
            if(cache.getOrDefault(now,0) > 0){
                answer += CACHE_HIT_TIME;
            }else{
                answer += CACHE_MISS_TIME;
                while(cache.size() >= Math.max(cacheSize,1) ) {
                    String prev = cities[prevIndex++].toUpperCase();
                    int cnt = cache.getOrDefault(prev,0);
                    if(cnt == 0){
                        continue;
                    }
                    cnt--;
                    if(cnt == 0){
                        cache.remove(prev);
                    }else{
                        cache.put(prev,cnt);
                    }
                }
            }
            if(cacheSize != 0){
                int cnt = cache.getOrDefault(now,0);
                cache.put(now,cnt+1);
            }
        }
        return answer;
    }
}
