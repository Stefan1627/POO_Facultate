import java.util.*;

abstract class User {
    protected String firstName, lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

interface Observer {
    void update(Notification notification);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Grade grade);
}

class Notification {
    private String message;

    public Notification(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification: " + message;
    }
}

class Student extends User {
    private Parent mother;
    private Parent father;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void setMother(Parent mother) {
        this.mother = mother;
    }

    public void setFather(Parent father) {
        this.father = father;
    }

    public Parent getMother() {
        return mother;
    }

    public Parent getFather() {
        return father;
    }

    public boolean isParent(Observer parent) {
        return parent == mother || parent == father;
    }
}

class Parent extends User implements Observer {
    private List<Notification> notifications;

    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
        notifications = new ArrayList<>();
    }

    @Override
    public void update(Notification notification) {
        notifications.add(notification);
        System.out.println("Parent " + this + " received: " + notification);
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}

class Assistant extends User {
    public Assistant(String firstName, String lastName) {
        super(firstName, lastName);
    }
}

class Teacher extends User {
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }
}

class UserFactory {
    public static User createUser(String userType, String firstName, String lastName) {
        switch (userType) {
            case "Student":
                return new Student(firstName, lastName);
            case "Parent":
                return new Parent(firstName, lastName);
            case "Assistant":
                return new Assistant(firstName, lastName);
            case "Teacher":
                return new Teacher(firstName, lastName);
            default:
                throw new IllegalArgumentException("Unknown user type: " + userType);
        }
    }
}

class Grade implements Comparable<Grade> {
    private Double partialScore, examScore;
    private Student student;
    private String course;

    public Grade(String course, Student student) {
        this.partialScore = 0.0;
        this.examScore = 0.0;
        this.course = course;
        this.student = student;
    }

    public Grade(String course, Student student, Double partialScore, Double examScore) {
        this.partialScore = partialScore;
        this.examScore = examScore;
        this.course = course;
        this.student = student;
    }

    public void setPartialScore(Double score) {
        partialScore = score;
    }

    public void setExamScore(Double score) {
        examScore = score;
    }

    public Double getPartialScore() {
        return partialScore;
    }

    public Double getExamScore() {
        return examScore;
    }

    public Double getTotal() {
        return partialScore + examScore;
    }

    @Override
    public int compareTo(Grade other) {
        return Double.compare(this.getTotal(), other.getTotal());
    }

    public Student getStudent() {
        return student;
    }
}

interface Strategy {
    Student getBestStudent(Collection<Grade> grades);
}

class BestPartialScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        return grades.stream()
                .max(Comparator.comparingDouble(Grade::getPartialScore))
                .map(Grade::getStudent)
                .orElse(null);
    }
}

class BestExamScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        return grades.stream()
                .max(Comparator.comparingDouble(Grade::getExamScore))
                .map(Grade::getStudent)
                .orElse(null);
    }
}

class BestTotalScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        return grades.stream()
                .max(Comparator.comparingDouble(Grade::getTotal))
                .map(Grade::getStudent)
                .orElse(null);
    }
}

class Course {
    private String name;
    private Teacher teacher;
    private List<Assistant> assistants;
    private List<Student> students;
    private List<Grade> grades;
    private Strategy strategy;

    private Course(CourseBuilder builder) {
        this.name = builder.name;
        this.teacher = builder.teacher;
        this.assistants = builder.assistants;
        this.students = builder.students;
        this.grades = builder.grades;
        this.strategy = builder.strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Student getBestStudent() {
        if (strategy == null) {
            throw new IllegalStateException("Strategy is not set!");
        }
        return strategy.getBestStudent(grades);
    }

    @Override
    public String toString() {
        return "Course: " + name + "\n" +
                "Teacher: " + teacher + "\n" +
                "Assistants: " + assistants + "\n" +
                "Students: " + students + "\n" +
                "Grades: " + grades;
    }

    public static class CourseBuilder {
        private String name;
        private Teacher teacher;
        private List<Assistant> assistants = new ArrayList<>();
        private List<Student> students = new ArrayList<>();
        private List<Grade> grades = new ArrayList<>();
        private Strategy strategy;

        public CourseBuilder(String name) {
            this.name = name;
        }

        public CourseBuilder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder assistant(Assistant assistant) {
            this.assistants.add(assistant);
            return this;
        }

        public CourseBuilder student(Student student) {
            this.students.add(student);
            return this;
        }

        public CourseBuilder grade(Grade grade) {
            this.grades.add(grade);
            return this;
        }

        public CourseBuilder strategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}

class Catalog implements Subject {
    private static Catalog instance;
    private List<Course> courses;
    private List<Observer> observers;

    private Catalog() {
        courses = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized Catalog getInstance() {
        if (instance == null) {
            instance = new Catalog();
        }
        return instance;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        for (Observer observer : observers) {
            if (grade.getStudent().isParent(observer)) {
                observer.update(new Notification("Student " + grade.getStudent() + " received a grade: " + grade.getTotal()));
            }
        }
    }

    @Override
    public String toString() {
        return "Catalog: \n" + courses;
    }
}

class Test {
    public static void main(String[] args) {
        User studentA = UserFactory.createUser("Student", "A", "Popescu");
        User studentB = UserFactory.createUser("Student", "B", "Ionescu");
        User mother = UserFactory.createUser("Parent", "M_AC", "Ionescu");
        User father = UserFactory.createUser("Parent", "T_AC", "Ionescu");
        User teacher = UserFactory.createUser("Teacher", "Teacher", "Georgescu");
        User assistant = UserFactory.createUser("Assistant", "Assistant", "Popescu");

        Course course = new Course.CourseBuilder("POO")
                .teacher((Teacher) teacher)
                .assistant((Assistant) assistant)
                .student((Student) studentA)
                .student((Student) studentB)
                .grade(new Grade("POO", (Student) studentA, 8.0, 9.0))
                .grade(new Grade("POO", (Student) studentB, 7.5, 8.5))
                .strategy(new BestTotalScore())
                .build();

        Catalog catalog = Catalog.getInstance();
        catalog.addCourse(course);

        ((Student) studentB).setMother((Parent) mother);
        ((Student) studentB).setFather((Parent) father);

        catalog.addObserver((Parent) mother);
        catalog.addObserver((Parent) father);
        catalog.notifyObservers(new Grade("POO", (Student) studentB, 7.5, 8.5));

        System.out.println("Best Student (Total Score): " + course.getBestStudent());

        course.setStrategy(new BestPartialScore());
        System.out.println("Best Student (Partial Score): " + course.getBestStudent());

        course.setStrategy(new BestExamScore());
        System.out.println("Best Student (Exam Score): " + course.getBestStudent());
    }
}
