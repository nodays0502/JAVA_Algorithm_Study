package Programmers.ETC;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class 최댓값과_최솟값 {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split(" ");
        Function<String,Integer> stoi = Integer::parseInt;
        List<Integer> list = Arrays.stream(temp).map(stoi).collect(Collectors.toList());
        Collections.sort(list);
        answer = list.get(0) + " " + list.get(list.size()-1);
        return answer;
    }
}
