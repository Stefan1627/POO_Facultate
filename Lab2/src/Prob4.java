
import java.util.Objects;
import java.util.Random;
import java.util.Vector;

public class Prob4 {
    public static Vector<Integer> genereazaVector(int origin, int bound) {
        Vector<Integer> vector = new Vector<>();
        Random generator = new Random();
        for (int i = 0; i < 10; i++) {
            vector.add(generator.nextInt(origin, bound));
        }
        return vector;
    }

    public static Vector<Integer> reuniune(Vector<Integer> vector1, Vector<Integer> vector2) {
        Vector<Integer> reuniune = new Vector<>();
        reuniune.addAll(vector1);
        reuniune.addAll(vector2);
        return reuniune;

    }

    public static Vector<Integer> intersectie(Vector<Integer> vector1, Vector<Integer> vector2) {
        Vector<Integer> intersectie = new Vector<>();
        for (Integer integer : vector1) {
            for (Integer value : vector2) {
                if (Objects.equals(integer, value)) {
                    intersectie.add(integer);
                    break;
                }
            }
        }
        return intersectie;
    }

    public static Vector<Integer> diferenta(Vector<Integer> vector1, Vector<Integer> vector2) {
        Vector<Integer> diferenta = new Vector<>(vector1);
        diferenta.removeAll(vector2);

        return diferenta;
    }

    public static void main(String[] args) {
        Vector<Integer> vector1 = genereazaVector(0, 11);
        Vector<Integer> vector2 = genereazaVector(0, 11);

        Vector<Integer> reuniune = reuniune(vector1, vector2);
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(reuniune);

        Vector<Integer> intersectie = intersectie(vector1, vector2);
        System.out.println(intersectie);

        Vector<Integer> diferenta = diferenta(vector1, vector2);
        System.out.println(diferenta);
    }
}
