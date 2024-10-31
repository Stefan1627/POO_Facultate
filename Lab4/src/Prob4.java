import java.util.Vector;

class Person {
    private String name;
    private String address;

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
    private Vector<String> course;
    private Vector<Integer> grades;

    public Student(String name, String address) {
        super(name, address);
        course = new Vector<>();
        grades = new Vector<>();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name=" + getName() +
                ", address=" + getAddress() +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }

    public void addCourseGrade(String course, int grades) {
        this.course.add(course);
        this.grades.add(grades);
    }

    public void printGrades() {
        System.out.println(grades);
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
    private Vector<String> courses;
    public Teacher(String name, String address) {
        super(name, address);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "courses=" + courses +
                '}';
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

class Test4 {
    public static void main(String args[]) {
        Person student, teacher, person;
        student = new Student("Popescu Ion", "Bucuresti");
        teacher = new Teacher("Ionescu Gigel", "Bucuresti");
        person = new Person("Maria", "Iasi");
        assert (person.getName().equals("Maria")) : "Metoda getName din clasa Person nu este implementata corect";
        assert (((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Algoritmica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).addCourse("Matematica")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (((Teacher) teacher).removeCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        assert (!((Teacher) teacher).addCourse("Programare")) : "Metoda addCourse din clasa Teacher nu este " +
                "implementata corect";
        ((Student) student).addCourseGrade("Programare", 10);
        ((Student) student).addCourseGrade("Algoritmica", 9);
        ((Student) student).addCourseGrade("Matematica", 8);
        assert (Math.abs(((Student) student).getAverageGrade() - 9.00) <= 0.001) : "Metoda getAverageGrade din clasa " +
                "Student nu a fost implementat corect";
        ((Student) student).printGrades();
        //Ce metoda toString se va apela? Din ce clasa?
        System.out.println(student);
        System.out.println(person);
        System.out.println("Felicitari! Problema a fost rezolvata corect!");
    }
}