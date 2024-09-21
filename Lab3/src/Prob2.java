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

    public double getTotalPrice() {
        return price * count;
    }
}

class Magazin {
    // Atributele clasei Magazin
    private String nume;
    private Produs[] produse;

    // Constructorul cu parametri
    public Magazin(String nume, Produs[] produse) {
        this.nume = nume;
        this.produse = produse;
    }

    // Metoda toString pentru afișarea detaliilor magazinului
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Magazin " + nume + " conține:\n");
        for (Produs produs : produse) {
            sb.append(produs.toString()).append("\n");
        }
        return sb.toString();
    }

    // Metoda care returnează suma totală a tuturor produselor din magazin
    public double getTotalMagazin() {
        double total = 0;
        for (Produs produs : produse) {
            total += produs.getTotalPrice();
        }
        return total;
    }
}

public class Prob2 {
    public static void main(String[] args) {
        // Creăm un obiect de tip Magazin, folosind produse anonime
        Magazin magazin = new Magazin("Magazinul Meu", new Produs[] {
                new Produs("Lapte", 5.5, 10),
                new Produs("Pâine", 2.3, 20),
                new Produs("Mere", 3.0, 15)
        });

        // Afișăm detaliile magazinului
        System.out.println(magazin.toString());

        // Afișăm totalul valorii produselor din magazin
        System.out.println("Total valoare produse în magazin: " + magazin.getTotalMagazin());
    }
}




