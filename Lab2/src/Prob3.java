import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class Prob3 {
    public static int eliminaAparitii(Vector<Integer> v, int x) {
        int count = 0;
        while (v.contains(x)) {

            v.remove((Integer) x);
            count++;
        }
        return count;
    }

    public static int pozitiaMinimului(Vector<Integer> v) {
        int min = v.getFirst();
        int pozitie = 0;
        for (int i = 1; i < v.size(); i++) {
            if (v.get(i) < min) {
                min = v.get(i);
                pozitie = i;
            }
        }
        return pozitie;
    }

    public static double mediaAritmetica(Vector<Integer> v) {
        int suma = 0;
        for (int num : v) {
            suma += num;
        }
        return suma / (double) v.size();
    }

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        int nr;
        for (int i = 0; i < 20; i++) {
            Random rand = new Random();
            nr = rand.nextInt(11);
            v.addElement(nr);
        }

        System.out.println(v);
        nr = eliminaAparitii(v, 5);
        System.out.println(nr);
        System.out.println(v);
        nr = pozitiaMinimului(v);
        System.out.println(nr);
        System.out.println(mediaAritmetica(v));
        nr = Collections.max(v);
        System.out.println(nr);
    }
}