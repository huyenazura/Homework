public class Main {
    public static void main(String[] args) {
        Student s1= new Student("Thuy", 24);
        s1.display();

    }
}
class Student
{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void display(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}