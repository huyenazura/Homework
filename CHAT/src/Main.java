import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        // BÀI 1
        System.out.println("=====================BÀI 1=====================");
        // Tạo Supplier đọc dữ liệu từ file, trả về List
        Supplier<List<String>> dataSupplier = () -> {
            List<String> data = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    data.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        };

        // Tạo List từ Supplier
        List<String> dataList = dataSupplier.get();
        System.out.println("Data from file:");
        dataList.forEach(System.out::println);

        // BÀI 2
        System.out.println("=====================BÀI 2=====================");
        // Tạo Consumer
        Consumer<String> stringConsumer = System.out::println;

        // Sử dụng Consumer
        System.out.println("Using Consumer:");
        stringConsumer.accept("Hello, world!");

        // BÀI 3
        System.out.println("=====================BÀI 3=====================");
        // Tạo Function
        Function<String, Integer> stringLengthFunction = String::length;

        // Sử dụng Function để biến đổi dữ liệu
        String inputString = "Hello";
        int length = stringLengthFunction.apply(inputString);
        System.out.println("Length of '" + inputString + "': " + length);

        // BÀI 4
        System.out.println("=====================BÀI 4=====================");
        // Tạo Predicate
        Predicate<Integer> isEvenPredicate = num -> num % 2 == 0;

        // Sử dụng Predicate trên để lọc dữ liệu
        System.out.println("Using Predicate:");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .filter(isEvenPredicate)
                .forEach(System.out::println);

        // BÀI 5
        System.out.println("=====================BÀI 5=====================");
        // Tạo Operator
        BinaryOperator<Integer> sumOperator = Integer::sum;

        // Sử dụng Operator trên để xử lý dữ liệu
        int result = sumOperator.apply(5, 3);
        System.out.println("5 + 3 = " + result);

        // Tạo Comparator
        Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);

        // Sử dụng Comparator để sắp xếp danh sách sinh viên
        List<String> students = List.of("Alice", "Bob", "Charlie", "David");
        System.out.println("Before sorting:");
        students.forEach(System.out::println);
        students.sort(stringLengthComparator);
        System.out.println("After sorting by length:");
        students.forEach(System.out::println);
    }
}
