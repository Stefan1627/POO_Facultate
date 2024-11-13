import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;

// Definim clasa de exceptie personalizata
class NumarNegativ extends Exception {
    public NumarNegativ() {
        super("Numarul introdus este negativ!");
    }
}

public class Prob3 {
    private Vector<Integer> numerePozitive = new Vector<>();

    public void myRead() throws NumarNegativ {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int numar = scanner.nextInt();
            if (numar < 0) {
                throw new NumarNegativ();
            }
            numerePozitive.add(numar);
        }
    }

    public int getMax() {
        return Collections.max(numerePozitive);
    }

    public static void main(String[] args) {
        Prob3 program = new Prob3();

        try {
            program.myRead();
        } catch (NumarNegativ e) {
            System.out.println(e.getMessage());
        }

        System.out.println(program.getMax());
    }
}
