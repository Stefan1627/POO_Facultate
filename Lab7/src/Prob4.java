import java.util.*;
import java.io.*;

public class Prob4 {
    public static void main(String[] args) {
        TreeMap<String, LinkedList<Integer>> map = new TreeMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("test01.txt"));
            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.replaceAll("[^a-zA-Z]", "").split("\\s+");

                for (String token : tokens) {
                    if (!token.isEmpty()) {
                        map.putIfAbsent(token, new LinkedList<>());
                        map.get(token).add(lineNum);
                    }
                }

                lineNum++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Map.Entry<String, LinkedList<Integer>> entry : map.entrySet()) {
            String key = entry.getKey();
            LinkedList<Integer> value = entry.getValue();

            System.out.println(key);
            Iterator<Integer> iterator = value.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println(value.size());
        }
    }
}
