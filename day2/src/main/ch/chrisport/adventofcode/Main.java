package ch.chrisport.adventofcode;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        var task1Solution = task1(Input.input);
        System.out.println("Solution task 1: " + task1Solution);
        var task2Solution = task2(Input.input);
        System.out.println("Solution task 2: " + task2Solution);
    }

    static Long task1(String input) {
        var result = Stream.of(input.split(System.getProperty("line.separator")))
                .flatMap(s -> s.chars().mapToObj(e -> (char) e)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values().parallelStream().filter(e -> e == 2 || e == 3)
                        .distinct())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().reduce((aLong, aLong2) -> aLong * aLong2);
        return result.get();
    }

    static String task2(String input) {
        var codes = input.split(System.getProperty("line.separator"));
        for (int a = 0; a < codes.length; a++) {
            for (int b = a + 1; b < codes.length; b++) {
                if (hasStringDistance1(codes[a], codes[b])) {
                    return intersectingString(codes[a], codes[b]);
                }
            }
        }
        return null;
    }

    static String intersectingString(String a, String b) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                s.append(a.charAt(i));
            }
        }
        return s.toString();
    }

    static boolean hasStringDistance1(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}