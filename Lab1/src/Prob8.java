import java.util.Arrays;

public class Prob8 {
    public static void main(String[] args) {
        double[] vector = new double[10];

        for (int i = 0; i < 10; i++) {
            vector[i] = Math.random() * 100;
        }

        Arrays.sort(vector);
        for (int i = 0; i < 10; i++) {
            System.out.println(vector[i]);
        }

        System.out.println(Arrays.binarySearch(vector, 10));
    }
}
