import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Prob1 {
    public static TreeSet<String> printWords(String filename) {
        TreeSet<String> words = new TreeSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                String tokens[] = line.split(" ");
                for (String token : tokens) {
                    words.add(token);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    public static TreeSet<String> printWordsComparator(TreeSet<String> words) {
        TreeSet<String> sortedWords = new TreeSet<>(Comparator.reverseOrder());
        sortedWords.addAll(words);
        return sortedWords;
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");

        String filename = "test01.txt";
        TreeSet<String> words = printWords(filename);
        System.out.println(words);

        TreeSet<String> sortedWords = printWordsComparator(words);
        System.out.println(sortedWords);
    }
}