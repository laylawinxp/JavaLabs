import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 2, 3, 53, 76, 24, 9, -5, 0, 7, 1, 53, 0, 1, 6, 17, 20);
        System.out.println(intList);
        System.out.println("~ Поиск среднего значения: " + StreamMethod.getAverage(intList));
        System.out.println("~ Квадраты неповторяющихся элементов: " + StreamMethod.getSquaresIfNoDuplicate(intList));
        int[] intArr = {0, 1, 7, 9, 10, 12, 4, -4};
        System.out.println("\n" + Arrays.toString(intArr));
        System.out.println("~ Сумма четных: " + StreamMethod.getSumIfEven(intArr));
        List<String> strList = List.of("java", "work", "name", "gift", "shrimp", "fish", "game", "forrest", "",
                "apple", "root", "console", "cook", "cracker", "without", "me", "icon", "Fish", "fly", "food", "store");
        System.out.println("\n" + strList);
        System.out.println("~ Добавление _new_ & toUpperCase: " + StreamMethod.toUpperCaseAndNew(strList));
        System.out.println("~ Строки, начинающиеся с f (упорядоченно): " + StreamMethod.getSortedIfStartingBy(strList, 'f'));
        System.out.println("~ Строки, начинающиеся с c (упорядоченно): " + StreamMethod.getSortedIfStartingBy(strList, 'c'));
        System.out.println("~ Строки, начинающиеся с t (упорядоченно): " + StreamMethod.getSortedIfStartingBy(strList, 't'));
        try {
            System.out.println("~ Последний элемент: " + StreamMethod.getLastElement(strList));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("~ Преобразование в Map: " + StreamMethod.getMap(strList));
    }
}