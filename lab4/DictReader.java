import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class DictReader {
    public static HashMap<String, String> dict = new HashMap<>();
    private final static String eng = "^([\\sa-zA-z]+)$";
    private final static String rus = "^([\\sА-Яа-яЁё]+)$";

    private static String formatString(String str) {
        return str.trim().replaceAll("\\s+", " ").toLowerCase();
    }

    public static void readDict() throws FileReadException, InvalidFileFormatException {
        File file = new File("dict.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new FileReadException("Error: Проблема с открытием файла со словарем\n");
        }
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\|");
            if (parts.length != 2 ){
                throw new InvalidFileFormatException("Error: Чтение словаря осуществляется в следующем формате: слово/выражение | перевод\n");
            }
            else if (parts[0].matches(eng) && parts[1].matches(rus)) {
                parts[0] = formatString(parts[0]);
                parts[1] = formatString(parts[1]);
                dict.put(parts[0], parts[1]);
            }
        }
        scanner.close();
    }
}
