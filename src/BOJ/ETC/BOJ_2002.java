package BOJ.ETC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class BOJ_2002 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        List<String> input = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            input.add(command);
            map.put(command,i);
        }
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            String command = br.readLine();
            int index = map.get(command);
            for(int j = 0 ; j < index ; j++){
                if(!used.contains(input.get(j))){
                    result++;
                    break;
                }
            }
            used.add(command);
        }
        System.out.println(result);
    }
}
