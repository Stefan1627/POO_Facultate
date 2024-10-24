class Fractie {
    int numarator;
    int numitor;


    public Fractie(int numarator, int numitor) {
        if (numitor == 0) {
            throw new ArithmeticException();
        }
        this.numarator = numarator;
        this.numitor = numitor;
    }

    public Fractie() {
        this.numarator = 0;
        this.numitor = 1;
    }

    @Override
    public String toString() {
        return "Fractie{" +
                "numarator=" + numarator +
                ", numitor=" + numitor +
                '}';
    }

    public Fractie aduna(Fractie alta) {
        int numaratorNou = this.numarator * alta.numitor + this.numitor * alta.numarator;
        int numitorNou = this.numitor * alta.numitor;
        return new Fractie(numaratorNou, numitorNou);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Fractie fractie = (Fractie) obj;
        return this.numarator == fractie.numarator && this.numitor == fractie.numitor;
    }

    public static void main(String[] args) {
        Fractie f1 = new Fractie(1, 2);
        Fractie f2 = new Fractie(3, 4);

        Fractie suma = f1.aduna(f2);
        System.out.println(f1 + " + " + f2 + " = " + suma);

        System.out.println("Fracția f1: " + f1);
        System.out.println("Fracția f2: " + f2);

        Fractie f3 = new Fractie(2, 4);
        System.out.println(f1 + " este egală cu " + f3 + "? " + f1.equals(f3));
    }
}