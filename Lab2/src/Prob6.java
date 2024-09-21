import java.util.StringTokenizer;
import java.util.Vector;

public class Prob6 {
    public static void result(String string, Vector<Integer> a) {
        StringTokenizer st = new StringTokenizer(string, " ,");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken() + ": " + a.getFirst());
            a.removeFirst();
        }
    }

    public static void main(String[] args) {
        String string = "int, double, float, String, char, boolean";

        Vector<Integer> a = new Vector<>();
        for (int i = 0; i < 6; i++) {
            a.add(0);
        }

        Vector v = new Vector();
        v.add(5);
        v.add(7);
        v.add('s');
        v.add(true);
        v.add(7.5);
        v.add("String");

        while (!v.isEmpty()) {
            String b = String.valueOf(v.getLast().getClass());
            if (b.contains("Integer")) {
                a.set(0, a.getFirst() + 1);
            }
            if (b.contains("Double")) {
                a.set(1, a.get(1) + 1);
            }
            if (b.contains("Float")) {
                a.set(2, a.get(2) + 1);
            }
            if (b.contains("String")) {
                a.set(3, a.get(3) + 1);
            }
            if (b.contains("Char")) {
                a.set(4, a.get(4) + 1);
            }
            if (b.contains("Boolean")) {
                a.set(5, a.get(5) + 1);
            }
            v.removeLast();
        }
        result(string, a);
    }
}
