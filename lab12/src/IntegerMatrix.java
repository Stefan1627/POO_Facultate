import java.util.*;

abstract class AMatrix<T extends Number> extends ArrayList<ArrayList<T>> {
    public abstract AMatrix<T> addition(AMatrix<T> m1);
    public abstract T sum(T obj1, T obj2);
}

public class IntegerMatrix extends AMatrix<Integer> {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> row : this) {
            for (Integer elem : row) {
                sb.append(elem).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Integer sum(Integer obj1, Integer obj2) {
        return obj1 + obj2;
    }

    @Override
    public AMatrix<Integer> addition(AMatrix<Integer> m) {
        if (this.size() != m.size() || this.get(0).size() != m.get(0).size()) {
            throw new IllegalArgumentException("Matricele trebuie sa aiba aceleasi dimensiuni!");
        }

        IntegerMatrix result = new IntegerMatrix();

        for (int i = 0; i < this.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < this.get(i).size(); j++) {
                row.add(sum(this.get(i).get(j), m.get(i).get(j)));
            }
            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {
        IntegerMatrix matrix1 = new IntegerMatrix();
        IntegerMatrix matrix2 = new IntegerMatrix();

        matrix1.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        matrix1.add(new ArrayList<>(Arrays.asList(4, 5, 6)));

        matrix2.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        matrix2.add(new ArrayList<>(Arrays.asList(10, 11, 12)));

        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        IntegerMatrix sumMatrix = (IntegerMatrix) matrix1.addition(matrix2);
        System.out.println("Sum Matrix:");
        System.out.println(sumMatrix);
    }
}
