import java.util.*;
import java.io.*;

class CustomFileFilter implements FilenameFilter {
    private List<String> allowedExtensions;
    private List<String> requiredWords;

    public CustomFileFilter(List<String> allowedExtensions, List<String> requiredWords) {
        this.allowedExtensions = allowedExtensions;
        this.requiredWords = requiredWords;
    }

    @Override
    public boolean accept(File dir, String name) {
        boolean validExtension = allowedExtensions.stream().anyMatch(x -> x.equals(name));
        boolean validWord = requiredWords.stream().anyMatch(x -> x.equals(name));
        return validExtension && validWord;
    }
}

public class Prob4 {
    public static List<String> readExtensions(String filename) throws FileNotFoundException {
        return readFileLines(filename);
    }

    public static List<String> readWords(String filename) throws FileNotFoundException {
        return readFileLines(filename);
    }

    public static List<String> readFileLines(String filename) {
        List<String> lines = new ArrayList<>();
        System.out.println("Reading file: " + filename);
        try {
            RandomAccessFile file = new RandomAccessFile(filename, "r");
            String line;
            while ((line = file.readLine()) != null) {
                lines.add(line);
            }
        }
        catch (Exception e) {
            System.out.println("Problem reading file "+ e.getMessage()+ filename);
        }
        return lines;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> extensions = readExtensions("extension.in");
        List<String> words = readWords("words.in");

        CustomFileFilter filter = new CustomFileFilter(extensions, words);

        File directory = new File("director/");

        if (directory.exists()) {
            String[] files = directory.list(filter);
            for (String filename : files) {
                System.out.println(filename);
            }
        }
    }
}
