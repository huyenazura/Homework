import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String input = "National Economic University";
        Map<Character, Integer> frequencyMap = getCharacterFrequency(input);

        // In kết quả
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("Ký tự: '" + entry.getKey() + "', Count: " + entry.getValue());
        }
    }

    // Phương thức để thống kê số lần xuất hiện của mỗi ký tự trong chuỗi
    public static Map<Character, Integer> getCharacterFrequency(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Duyệt qua từng ký tự trong chuỗi
        for (char ch : input.toCharArray()) {
            // Nếu ký tự đã có trong map, tăng giá trị đếm lên 1
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        return frequencyMap;
    }
}
