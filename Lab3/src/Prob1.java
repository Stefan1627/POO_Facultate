class Fractie {
    // Atribute: numărător și numitor
    private int numarator;
    private int numitor;

    // Constructor cu parametri
    public Fractie(int numarator, int numitor) {
        if (numitor == 0) {
            throw new IllegalArgumentException("Numitorul nu poate fi zero!");
        }
        this.numarator = numarator;
        this.numitor = numitor;
        simplifica(); // Simplificăm fracția imediat după creare
    }

    // Constructor fără parametri
    public Fractie() {
        this(0, 1); // Apelăm constructorul cu parametri și setăm fracția implicită 0/1
    }

    // Metodă pentru simplificarea fracției
    private void simplifica() {
        int gcd = gcd(numarator, numitor); // Calculăm cel mai mare divizor comun
        this.numarator /= gcd;
        this.numitor /= gcd;

        // Asigurăm semnul corect (numitorul trebuie să fie întotdeauna pozitiv)
        if (this.numitor < 0) {
            this.numarator = -this.numarator;
            this.numitor = -this.numitor;
        }
    }

    // Calculul celui mai mare divizor comun (algoritmul lui Euclid)
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Metodă pentru calculul sumei a două fracții
    public Fractie aduna(Fractie alta) {
        int numaratorNou = this.numarator * alta.numitor + this.numitor * alta.numarator;
        int numitorNou = this.numitor * alta.numitor;
        return new Fractie(numaratorNou, numitorNou); // Returnăm o nouă fracție rezultată
    }

    // Metoda toString pentru afișarea fracției
    @Override
    public String toString() {
        if (numitor == 1) {
            return Integer.toString(numarator); // Dacă numitorul este 1, afișăm doar numărătorul
        }
        return numarator + "/" + numitor;
    }

    // Metoda equals pentru compararea a două fracții
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

    // Metoda main pentru testarea clasei
    public static void main(String[] args) {
        // Creăm două fracții
        Fractie f1 = new Fractie(1, 2);
        Fractie f2 = new Fractie(3, 4);

        // Testăm adunarea fracțiilor
        Fractie suma = f1.aduna(f2);
        System.out.println(f1 + " + " + f2 + " = " + suma);

        // Testăm metoda toString
        System.out.println("Fracția f1: " + f1);
        System.out.println("Fracția f2: " + f2);

        // Testăm metoda equals
        Fractie f3 = new Fractie(2, 4);
        System.out.println(f1 + " este egală cu " + f3 + "? " + f1.equals(f3));
    }
}

