class Produs {
    String name;
    double price;
    int count;

    public Produs(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Produs" + name + " " + price + " " + count;
    }

    public double getTotalProdus() {
        return price * count;
    }
}

class Magazin {
    private String nume;
    private Produs[] produse;

    public Magazin(String nume, Produs[] produse) {
        this.nume = nume;
        this.produse = produse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Magazin " + nume + " conține:\n");
        for (Produs produs : produse) {
            sb.append(produs.toString()).append("\n");
        }
        return sb.toString();
    }

    public double getTotalMagazin() {
        double total = 0;
        for (Produs produs : produse) {
            total += produs.getTotalProdus();
        }
        return total;
    }
}

public class Prob2 {
    public static void main(String[] args) {
        Magazin magazin = new Magazin("Magazinul Meu", new Produs[] {
                new Produs("Kox", 80, 10),
                new Produs("Ciocolata", 10, 20),
                new Produs("Mere", 5, 15)
        });

        System.out.println(magazin);
        System.out.println("Total valoare produse în magazin: " + magazin.getTotalMagazin());
    }
}