//import java.util.*;
//
//abstract class User {
//    protected String firstName, lastName;
//
//    public User(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    @Override
//    public String toString() {
//        return firstName + " " + lastName;
//    }
//}
//
//class Student extends User {
//    private Parent mother;
//    private Parent father;
//
//    public Student(String firstName, String lastName) {
//        super(firstName, lastName);
//    }
//
//    public void setMother(Parent mother) {
//        this.mother = mother;
//    }
//
//    public void setFather(Parent father) {
//        this.father = father;
//    }
//
//    public Parent getMother() {
//        return mother;
//    }
//
//    public Parent getFather() {
//        return father;
//    }
//}
//
//class Parent extends User {
//    public Parent(String firstName, String lastName) {
//        super(firstName, lastName);
//    }
//}
//
//class Assistant extends User {
//    public Assistant(String firstName, String lastName) {
//        super(firstName, lastName);
//    }
//}
//
//class Teacher extends User {
//    public Teacher(String firstName, String lastName) {
//        super(firstName, lastName);
//    }
//}
//
//class UserFactory {
//    public static User createUser(String userType, String firstName, String lastName) {
//        switch (userType) {
//            case "Student":
//                return new Student(firstName, lastName);
//            case "Parent":
//                return new Parent(firstName, lastName);
//            case "Assistant":
//                return new Assistant(firstName, lastName);
//            case "Teacher":
//                return new Teacher(firstName, lastName);
//            default:
//                throw new IllegalArgumentException("Unknown user type: " + userType);
//        }
//    }
//}
//
//class Test {
//    public static void main(String[] args) {
//        // Testare exercitiu 2
//        User studentA = UserFactory.createUser("Student", "A", "Popescu");
//        User studentB = UserFactory.createUser("Student", "B", "Ionescu");
//        User studentC = UserFactory.createUser("Student", "C", "Ionescu");
//
//        User mother = UserFactory.createUser("Parent", "M_AC", "Ionescu");
//        User father = UserFactory.createUser("Parent", "T_AC", "Ionescu");
//
//        User teacher = UserFactory.createUser("Teacher", "Teacher", "Georgescu");
//        User assistant = UserFactory.createUser("Assistant", "Assistant", "Popescu");
//
//        System.out.println(studentA);
//        System.out.println(mother);
//        System.out.println(teacher);
//    }
//}