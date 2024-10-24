class Numar {
    int num;
    public Numar(int num) {
        this.num = num;
    }

    public int sum(int a) {
        return num + a;
    }

    public int sum(int a, int b) {
        return sum(a) + b;
    }

    public int sum(int a, int b, int c) {
        return sum(a, b) + c;
    }

    public int sum(int a, int b, int c, int d) {
        return sum(a, b, c) + d;
    }

    public static void main(String[] args) {
        Numar numar = new Numar(5);
        System.out.println(numar.sum(5));
        System.out.println(numar.sum(5, 6));
        System.out.println(numar.sum(5, 6, 7));
        System.out.println(numar.sum(5, 6, 7, 8));
    }
}