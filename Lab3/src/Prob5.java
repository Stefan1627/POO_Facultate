class Punct {
    private int x;
    private int y;

    public Punct() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /*public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }*/

    public double distance(Punct p1) {
        return Math.sqrt(Math.pow(this.x - p1.getX(), 2) + Math.pow(this.y - p1.getY(), 2));
    }
}


public class Prob5 {
    public static void main(String[] args) {
        // Creăm două puncte A(1, 2) și B(-1, 3)
        Punct A = new Punct();
        A.setX(1);
        A.setY(2);

        Punct B = new Punct();
        B.setX(-1);
        B.setY(3);

        // Calculăm distanța dintre punctele A și B folosind metoda distance
        double dist = A.distance(B);

        // Afișăm rezultatul
        System.out.println("Distanța dintre punctele A" + A + " și B" + B + " este: " + dist);
    }
}
