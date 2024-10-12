public class Prob6 {

    public static void main(String[] args) {
        Prob6 p = new Prob6();

        for (int x = 0; x < 21; x++) {
            System.out.println(x);
            System.out.println(p.prim(x) ? "prim" : "not prim");
        }
    }

    public boolean prim(int nr) {
        if (nr < 2)
            return false;
        for (int i = 2; i < nr; i++) {
            if (nr % i == 0)
                return false;
        }
        return true;
    }
}
