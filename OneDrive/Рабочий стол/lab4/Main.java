public class Main {
    public static void main(String[] args) {
        try {
            DictReader.readDict();
            Translator.translate();
        }
        catch (InvalidFileFormatException | FileReadException e) {
            System.out.println(e.getMessage());
        }
    }
}