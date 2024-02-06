import java.util.Arrays;
import java.util.List;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMethod {
    public static double getAverage(List<Integer> integers) {
        return integers.stream()
                .mapToInt(integer -> integer)
                .average()
                .orElse(0);
    }

    public static List<String> toUpperCaseAndNew(List<String> strings) {
        return strings.stream()
                .map(str -> "_new_" + str.toUpperCase())
                .toList();
    }

    public static List<Integer> getSquaresIfNoDuplicate(List<Integer> integers) {
        return integers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() == 1)
                .map(integer -> integer.getKey() * integer.getKey())
                .toList();
    }

    public static List<String> getSortedIfStartingBy(List<String> strings, char letter) {
        return strings.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == letter)
                .sorted()
                .toList();
    }

    public static <T> T getLastElement(Collection<T> collection) throws Exception {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new Exception("Collection is empty"));
    }

    public static int getSumIfEven(int[] arr) {
        return Arrays.stream(arr)
                .filter(element -> element % 2 == 0)
                .sum();
    }

    public static Map<Character, List<String>> getMap(List<String> strings) {
        return strings.stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.groupingBy(k -> k.charAt(0),
                        Collectors.mapping(v -> v.substring(1), Collectors.toList())));
    }
}
