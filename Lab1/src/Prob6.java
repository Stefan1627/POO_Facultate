public class Prob6 {

    public static void main(String[] args) {
        for (int x = 0; x < 21; x++) {
            boolean prim = prim(x);
            System.out.println(x);
            System.out.println(prim ? "prim" : "not prim");
        }
    }

    public static boolean prim(int nr) {
        if (nr < 2)
            return false;
        for (int i = 2; i < nr; i++) {
            if (nr % i == 0)
                return false;
        }
        return true;
    }
}
