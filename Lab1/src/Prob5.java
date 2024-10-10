public class Prob5 {
    public int mypow(int x, int y) {
        int result = 1;
        for (int i = 1; i <= y; i++) {
           result = result * x;
        }
        return result;
    }

    public static void main(String[] args) {
        Prob5 p = new Prob5();
        System.out.println(p.mypow(3, 4));
        System.out.println(Math.pow(3, 4));
    }


}
