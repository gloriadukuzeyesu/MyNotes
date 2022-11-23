public abstract class Student {
    public String name_ = "Angel";
   public int age_ = 90;

    public Student ( ){
    }

    public Student(String name, int age) {
        this.name_ = name;
        this.age_ = age;
    }

    public void print() {
        System.out.println("My name is " + name_ + "  and I am " + age_ + " old");
    }

    public static void main(String[] args) {

//        Student student1 = new Student("Hannah", 30);
//        student1.print();
    }
}

