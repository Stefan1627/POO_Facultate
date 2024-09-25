import static java.lang.Math.sin;

class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }
}

class Paralelogram extends Patrulater {
    public Paralelogram(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        super(latura1, latura2, latura3, latura4, unghi1, unghi2, unghi3, unghi4);
    }

    public double getAriePara() {
        return latura1 * latura2 * sin(unghi1);
    }
}

class Romb extends Paralelogram {
    public int diag1, diag2;

    public Romb(int latura, int diag1, int diag2) {
        super(latura, latura, latura, latura, 0, 0, 0 ,0);
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    public double getArieRomb() {
        return (double) (diag1 * diag2) / 2;
    }
}

class Dreptunghi extends Paralelogram {


    public Dreptunghi(int latura1, int latura2, int latura3, int latura4) {
        super(latura1, latura2, latura3, latura4, 0 , 0, 0, 0);
    }

    public double getArieDreptunghi() {
        return latura1 * latura2;
    }
}

class Patrat extends Dreptunghi {
    public Patrat (int latura) {
        super(latura, latura, latura, latura);
    }

    public double getArie() {
        return latura1 * latura2;
    }
}



public class Prob1 {
    public static void main(String[] args) {
        Patrat patrat = new Patrat(5);
        System.out.println(patrat.getArie());
    }
}