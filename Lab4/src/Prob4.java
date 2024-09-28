import java.util.Vector;

class Person {
    String name;
    String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + "]";
    }
}

class Student extends Person {
    Vector<String> courses;
    Vector<Integer> grades;

    public Student(String name, String address) {
        super(name, address);
        this.courses = new Vector<>();  // Initialize courses
        this.grades = new Vector<>();   // Initialize grades
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", address=" + address + ", courses=" + courses + ", grades=" + grades + "]";
    }

    public void addCourseGrade(String course, Integer grade) {
        this.courses.add(course);  // Add course to the list
        this.grades.add(grade);    // Add grade to the list
    }

    public void printGrades() {
        for (Integer grade : grades) {
            System.out.println(grade);
        }
    }

    public double getAverageGrade() {
        double total = 0;
        for (Integer grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }
}

class Teacher extends Person {
    Vector<String> courses;

    public Teacher(String name, String address) {
        super(name, address);
        this.courses = new Vector<>();  // Initialize courses
    }

    @Override
    public String toString() {
        return "Teacher [name=" + name + ", address=" + address + ", courses=" + courses + "]";
    }

    public boolean addCourse(String course) {
        if (courses.contains(course)) {
            return false;
        }
        courses.add(course);
        return true;
    }

    public boolean removeCourse(String course) {
        if (courses.contains(course)) {
            courses.remove(course);
            return true;
        }
        return false;
    }
}

public class Prob4 {
    public static void main(String[] args) {
        Student student;
        Teacher teacher;
        Person person;
        student = new Student("Popescu Ion", "Bucuresti");
        teacher = new Teacher("Ionescu Gigel", "Bucuresti");
        person = new Person("Maria", "Iasi");

        assert (person.getName().equals("Maria")) : "Metoda getName din clasa Person nu este implementata corect";
        assert (teacher.addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este implementata corect";
        assert (teacher.addCourse("Algoritmica")) : "Metoda addCourse din clasa Teacher nu este implementata corect";
        assert (teacher.addCourse("Matematica")) : "Metoda addCourse din clasa Teacher nu este implementata corect";
        assert (!teacher.addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este implementata corect";
        assert (teacher.removeCourse("Programare")) : "Metoda removeCourse din clasa Teacher nu este implementata corect";
        assert (!teacher.addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este implementata corect";

        student.addCourseGrade("Programare", 10);
        student.addCourseGrade("Algoritmica", 9);
        student.addCourseGrade("Matematica", 8);

        assert (Math.abs(student.getAverageGrade() - 9.00) <= 0.001) : "Metoda getAverageGrade din clasa Student nu a fost implementata corect";

        student.printGrades();

        // Ce metoda toString se va apela? Din ce clasa?
        System.out.println(student);  // Calls Student's toString method
        System.out.println(person);   // Calls Person's toString method
        System.out.println("Felicitari! Problema a fost rezolvata corect!");
    }
}
