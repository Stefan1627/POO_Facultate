public class Prob7 {
    public static void main(String[] args) {
        int y;
        boolean prim;
        for (int n = 1; n < 4; n++) {
            for (int k = 1; k <= n; k++) {
                y = (2 * n) - k;
                prim = Prob6.prim(y);
                if (prim || y == 1) {
                    System.out.println((2 * n) + " = " + k + " + " + y);
                    break;
                }
            }

        }
    }
}
