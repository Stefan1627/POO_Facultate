import java.util.*;

// Interfața Persoana, care extinde Comparable pentru a permite compararea
interface Persoana extends Comparable<Persoana> {
    public double calculMedieGenerala();
    public String getNume();
    public void setNume(String nume);
    public void addMedie(double medie);
}

// Clasa Student care implementează interfața Persoana
class Student implements Persoana {
    private String nume;
    private List<Double> medii;

    public Student(String nume) {
        this.nume = nume;
        medii = new ArrayList<>();
    }

    @Override
    public double calculMedieGenerala() {
        if (medii.isEmpty()) return 0;
        double suma = 0;
        for (double medie : medii) {
            suma += medie;
        }
        return suma / medii.size();
    }

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public void addMedie(double medie) {
        medii.add(medie);
    }

    @Override
    public int compareTo(Persoana other) {
        int comparareNume = nume.compareTo(other.getNume());
        if (comparareNume == 0) {
            double medieThis = calculMedieGenerala();
            double medieOther = other.calculMedieGenerala();
            return Double.compare(medieOther, medieThis);
        }
        return comparareNume;
    }

    @Override
    public String toString() {
        return "Student: " + nume + ", Medie Generală: " + calculMedieGenerala();
    }
}

public class Prob3 {
    public static void main(String[] args) {
        Vector<Student> studenti = new Vector<>();

        Student s1 = new Student("da");
        s1.addMedie(8.5);
        s1.addMedie(9.0);

        Student s2 = new Student("da1");
        s2.addMedie(9.5);
        s2.addMedie(7.0);

        Student s3 = new Student("da3");
        s3.addMedie(9.2);
        s3.addMedie(9.8);

        Student s4 = new Student("da2");
        s4.addMedie(6.5);
        s4.addMedie(8.0);

        studenti.add(s1);
        studenti.add(s2);
        studenti.add(s3);
        studenti.add(s4);

        Collections.sort(studenti);

        for (Student student : studenti) {
            System.out.println(student);
        }
    }
}
