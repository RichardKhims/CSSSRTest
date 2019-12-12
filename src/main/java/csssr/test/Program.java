package csssr.test;

import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        String s = "сапог сарай арбуз болт бокс биржа";

        groupStr(s).entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(System.out::println);
    }

    private static Map<Character, List<String>> groupStr(String words) {
        Map<Character, List<String>> map = Arrays.stream(words.split(" "))
                .collect(Collectors.groupingBy(word -> word.charAt(0), TreeMap::new, Collectors.toList()));

        map.forEach((key, value) -> value.sort((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return -1;
            } else if ((o1.length() < o2.length())) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        }));

        return map;
    }
}

