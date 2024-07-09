import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {5, 3, 2, 5, 3};

        // Sử dụng IntUnaryOperator để tính bình phương của một số
        IntUnaryOperator squareOperator = x -> x * x;

        // Tạo mảng mới chứa bình phương của các số từ mảng đã cho
        int[] squaredNumbers = Arrays.stream(numbers)
                .map(squareOperator)
                .toArray();

        // In ra mảng đã cho
        System.out.println("Mảng dữ liệu đầu vào " + Arrays.toString(numbers));
        // In ra mảng mới chứa bình phương của các số
        System.out.println("Mảng mới chứa bình phương các số đã cho " + Arrays.toString(squaredNumbers));
    }
}
