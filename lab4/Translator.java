import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Translator {
    private static ArrayList<String> defineKey(String curWord) {
        ArrayList<String> potentialWords = new ArrayList<>();
        for (String key : DictReader.dict.keySet()) {
            if (key.startsWith(curWord)) {
                potentialWords.add(key);
            }
        }
        return potentialWords;
    }

    private static String formatStr(String str) {
        return str.trim().toLowerCase().replaceAll("[^a-z\\s]+", "");
    }

    public static void translate() throws FileReadException {
        File file = new File("input.txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new FileReadException("Error: Проблема с открытием файла с текстом\n");
        }
        String currentWord;
        String nextWord = "";
        String prevWord = "";
        while (scanner.hasNext()) {
            if (!prevWord.isEmpty()) {
                currentWord = nextWord;
                prevWord = "";
            } else {
                currentWord = scanner.next();
            }
            currentWord = formatStr(currentWord);
            if (defineKey(currentWord).isEmpty()) {
                System.out.println(currentWord);
            } else {
                while (!defineKey(currentWord).isEmpty()) {
                    if (scanner.hasNext()) {
                        nextWord = formatStr(scanner.next());
                        prevWord = currentWord;
                        currentWord += " " + nextWord;
                    } else {
                        break;
                    }
                }
                if (defineKey(currentWord).size() == 1) {
                    prevWord = "";
                    String translatedStr = DictReader.dict.get((defineKey(currentWord).get(0)));
                    int countOfWordsIs = currentWord.split(" ").length;
                    int countOfWordsShouldBe = defineKey(currentWord).get(0).split(" ").length;
                    int dif = countOfWordsShouldBe - countOfWordsIs;
                    if (dif > 0) {
                        for (int i = 0; i < dif; ++i) {
                            if (scanner.hasNext()) {
                                scanner.next();
                            }
                        }
                    }
                    System.out.println(translatedStr);
                } else {
                    currentWord = prevWord;
                    String translatedStr = DictReader.dict.get((currentWord));
                    if (translatedStr != null) {
                        System.out.println(translatedStr);
                    } else {
                        System.out.println(currentWord);
                    }
                }
            }
        }
        scanner.close();
    }
}

