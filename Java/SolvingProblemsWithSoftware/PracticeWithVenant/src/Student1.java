import java.security.PublicKey;

public class Student1 {
    //fields
    String Name_;
    int Age_;

    public Student1 () {}
    public Student1 (String name) {}

     public Student1 (String name, int age) {
       Name_ = name;
      Age_ = age;
    }

    public void description ( ) {
        System.out.println(" I am "+ Name_ + "and I am " + Age_);
    }

    public void print () {
        System.out.println(" Printing from subClass");
    }

    public static void main(String[] args) {
        Student1 myStudent = new Student1("Gloria ", 10);
        myStudent.description();
        myStudent.print();
    }

}
