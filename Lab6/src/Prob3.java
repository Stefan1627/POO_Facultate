import java.util.*;

interface Persoana extends Comparable<Persoana> {
    public double calculMedie();
    public String getNume();
    public void setNume(String nume);
    public void addMedie(double medie);
}

class Student implements Persoana {
    private String nume;
    private List<Double> medie;

    public Student(String nume) {
        this.nume = nume;
        medie = new ArrayList<>();
    }


    @Override
    public double calculMedie() {
        if (medie.isEmpty())
            return 0;
        double sum = 0;
        for (Double aDouble : medie) {
            sum += aDouble;
        }
        return sum/medie.size();
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
        this.medie.add(medie);
    }

    @Override
    public int compareTo(Persoana o) {
        int comparaNume = o.getNume().compareTo(this.nume);
        if (comparaNume == 0) {
            double medieThis = calculMedie();
            double medieOther = o.calculMedie();
            return Double.compare(medieThis, medieOther);
        }
        return comparaNume;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", medie=" + medie +
                '}';
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