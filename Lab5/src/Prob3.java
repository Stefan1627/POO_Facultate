import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

class NumarNegativ extends Exception {
    public NumarNegativ() {
        super("Numarul introdus este negativ!");
    }
}

public class Prob3 {
    public static void main(String[] args) {
        Vector<Integer> a = null;
        try {
            a = myRead();
            System.out.println(a);
            int max = Collections.max(a);
            System.out.println(max);
        } catch (NumarNegativ n) {
            System.out.println(n);
        }

    }

    public static Vector<Integer> myRead() throws NumarNegativ {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector<Integer> a = new Vector<>();
        while (n >= 0) {
            a.add(n);
            n = sc.nextInt();
        }

        if (a.isEmpty()) {
            throw new NumarNegativ();
        }

        return a;
    }
}
