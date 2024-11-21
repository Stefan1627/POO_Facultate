import java.io.File;
import java.util.*;

public class Prob5 {
    public static void main(String[] args) {
        String directoryPath = ".";

        HashMap<String, Integer> fileSizes = new HashMap<>();

        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileSizes.put(file.getName(), (int) file.length());
                    }
                }
            }
        } else {
            System.out.println("Not a directory");
        }

        TreeMap<String, Integer> sortedFileSizes = new TreeMap<>(fileSizes);
        //in functie de nume
        for (Map.Entry<String, Integer> entry : sortedFileSizes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(fileSizes.entrySet());
        Collections.sort(list, Map.Entry.comparingByKey());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
