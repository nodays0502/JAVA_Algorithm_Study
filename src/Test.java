import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String replace = input.replace(" ", "");
        List<Integer> collect = Arrays.stream(replace.split(",")).map(Integer::parseInt)
            .collect(Collectors.toList());
        System.out.println(collect);
    }
}
