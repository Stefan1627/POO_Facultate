import java.util.Random;
import java.util.Vector;

public class Prob3 {
    // Metoda pentru generarea unui vector cu 20 de numere random din intervalul [0..10]
    public static Vector<Integer> genereazaVector() {
        Vector<Integer> vector = new Vector<>();
        Random generator = new Random();
        for (int i = 0; i < 20; i++) {
            vector.add(generator.nextInt(11));  // Generează numere între 0 și 10 (inclusiv)
        }
        return vector;
    }

    // Metoda care elimină toate aparițiile unui număr x din vector și întoarce numărul de apariții
    public static int eliminaAparitii(Vector<Integer> vector, int x) {
        int count = 0;
        while (vector.contains(x)) {
            vector.remove((Integer) x);  // Elimină prima apariție a lui x
            count++;
        }
        return count;
    }

    // Metoda pentru determinarea valorii maxime din vector
    public static int valoareMaxima(Vector<Integer> vector) {
        int max = vector.getFirst();
        for (int i = 1; i < vector.size(); i++) {
            if (vector.get(i) > max) {
                max = vector.get(i);
            }
        }
        return max;
    }

    // Metoda pentru determinarea poziției componentei minime din vector
    public static int pozitiaMinimului(Vector<Integer> vector) {
        int min = vector.getFirst();
        int pozitie = 0;
        for (int i = 1; i < vector.size(); i++) {
            if (vector.get(i) < min) {
                min = vector.get(i);
                pozitie = i;
            }
        }
        return pozitie;
    }

    // Metoda pentru calcularea mediei aritmetice a elementelor din vector
    public static double mediaAritmetica(Vector<Integer> vector) {
        int suma = 0;
        for (int num : vector) {
            suma += num;
        }
        return suma / (double) vector.size();
    }

    public static void main(String[] args) {
        // Generăm vectorul de 20 de numere random
        Vector<Integer> vector = genereazaVector();
        System.out.println("Vectorul generat: " + vector);

        // Eliminăm aparițiile unui număr x (exemplu: 5) și returnăm numărul de apariții
        int x = 5;
        int aparitiiEliminate = eliminaAparitii(vector, x);
        System.out.println("Numărul de apariții ale lui " + x + " eliminate: " + aparitiiEliminate);
        System.out.println("Vector după eliminare: " + vector);

        // Determinăm valoarea maximă din vector
        int max = valoareMaxima(vector);
        System.out.println("Valoarea maximă din vector: " + max);

        // Determinăm poziția componentei minime din vector
        int pozMin = pozitiaMinimului(vector);
        System.out.println("Poziția componentei minime: " + pozMin);

        // Calculăm media aritmetică a elementelor din vector
        double media = mediaAritmetica(vector);
        System.out.println("Media aritmetică a elementelor: " + media);
    }
}
