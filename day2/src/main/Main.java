import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        task1();

    }

    private static void task1(){
        var result = Stream.of(Input.input.split(System.getProperty("line.separator")))
                .flatMap(s -> s.chars().mapToObj(e -> (char) e)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values().parallelStream().filter(e -> e == 2 || e == 3)
                        .distinct())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().reduce((aLong, aLong2) -> aLong * aLong2);
        System.out.println(result.isPresent() ? result.get() : 0);
    }
}