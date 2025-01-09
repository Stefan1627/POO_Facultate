//import java.util.ArrayList;
//import java.util.List;
//
//class Course {
//    private String name;
//
//    public Course(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Course{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//}
//
//public class Catalog {
//    private static Catalog instance;
//    private List<Course> courses;
//
//    private Catalog() {
//        courses = new ArrayList<>();
//    }
//
//    public static Catalog getInstance() {
//        if (instance == null) {
//            instance = new Catalog();
//        }
//        return instance;
//    }
//
//    public void addCourse(Course course) {
//        courses.add(course);
//    }
//
//    public void removeCourse(Course course) {
//        courses.remove(course);
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("Catalog: \n");
//        for (Course course : courses) {
//            sb.append("- ").append(course).append("\n");
//        }
//        return sb.toString();
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        Catalog c = Catalog.getInstance();
//
//        c.addCourse(new Course("A"));
//        c.addCourse(new Course("B"));
//        c.addCourse(new Course("C"));
//
//        System.out.println(c);
//
//        c.removeCourse(new Course("B"));
//        System.out.println(c);
//    }
//}