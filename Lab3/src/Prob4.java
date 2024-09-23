class Numar {
    private int num;

    public Numar(int num) {
        this.num = num;
    }

    public int suma (int a) {
        return num + a;
    }

    public int suma (int a, int b) {
        return num + a + b;
    }

    public int suma (int a, int b, int c) {
        return num + a + b + c;
    }

    public int suma (int a, int b, int c, int d) {
        return num + a + b + c + d;
    }
}

public class Prob4 {
    public static void main(String[] args) {
        Numar num = new Numar(5);
        System.out.println(num.suma(5));
        System.out.println(num.suma(5, 2));
        System.out.println(num.suma(5, 2, 3));
        System.out.println(num.suma(5, 2, 3, 4));
    }
}
