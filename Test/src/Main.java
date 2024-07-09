import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //BÀI 1
        System.out.println("=====================BÀI 1=====================");
        //Tạo Supplier đọc dữ liệu từ file, trả về List
        Supplier<List<Student>> studentSupplier = () -> {
            List<Student> students = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String name = parts[0].trim();
                        int age = Integer.parseInt(parts[1].trim());
                        double score = Double.parseDouble(parts[2].trim());
                        students.add(new Student(name, age, score));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return students;
        };

        // Lấy danh sách sinh viên từ Supplier
        List<Student> studentList = studentSupplier.get();

        // Sử dụng Stream từ danh sách sinh viên
        Stream<Student> studentStream = studentList.stream();

        //BAI2
        System.out.println("=====================BÀI 2=====================");


        Consumer<Student> printStudentInfo = student -> System.out.println("Name: " + student.getName() +
                ", Age: " + student.getAge() +
                ", Score: " + student.getScore());

        // Sử dụng Consumer để in ra thông tin của 3 sinh viên đầu tiên trong Stream
        System.out.println("Thông tin của 3 sinh viên đầu tiên trong Stream:");
        studentStream.limit(3)
                .forEach(printStudentInfo);

        //BAI3
        System.out.println("=====================BÀI 3=====================");
        Function<Student, Integer> roundScore = student -> (int) Math.round(student.getScore());

        // In ra thông tin của 3 sinh viên đầu tiên trong Stream sau khi biến đổi
        System.out.println("Thông tin của 3 sinh viên đầu tiên trong Stream sau khi biến đổi:");
        studentList.stream().limit(3)
                .map(student -> new Student(student.getName(), student.getAge(), roundScore.apply(student)))
                .forEach(printStudentInfo);

        //BAI4
        System.out.println("=====================BÀI 4=====================");
        // Tạo Predicate để lọc sinh viên có điểm cao hơn hoặc bằng 9
        Predicate<Student> highScorePredicate = student -> student.getScore() >= 9.0;

        // Lọc ra các sinh viên có điểm cao hơn hoặc bằng 9 và in ra thông tin của 3 sinh viên đầu tiên trong Stream lọc
        System.out.println("Thông tin của 3 sinh viên có điểm cao hơn hoặc bằng 9:");
        studentList.stream()
                .filter(highScorePredicate)
                .limit(3)
                .forEach(printStudentInfo);
        //BAI5
        System.out.println("=====================BÀI 5=====================");
        // Tạo Comparator để sắp xếp sinh viên theo tuổi
        Comparator<Student> ageComparator = Comparator.comparingInt(Student::getAge);

        // Sắp xếp danh sách sinh viên theo tuổi
        studentList.sort(ageComparator.reversed());

        // In ra thông tin của 3 sinh viên có tuổi lớn nhất
        System.out.println("Thông tin của 3 sinh viên có tuổi lớn nhất:");
        studentList.stream()
                .limit(3)
                .forEach(printStudentInfo);
    }
}

class Student {
    String name;
    int age;
    double score;


    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

}