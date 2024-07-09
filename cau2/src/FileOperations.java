import java.io.*;
import java.nio.file.*;
import java.util.Random;
import java.time.Duration;
import java.time.Instant;

public class FileOperations {

    public static void main(String[] args) {
        try {
            // Phần a: Tạo file "data.txt" với 1 triệu số ngẫu nhiên
            createRandomNumbersFile("data.txt", 1000000);

            // Phần b: Sao chép file "data.txt" sang "new_data.txt"
            copyFileWithTime("data.txt", "new_data.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phần a: Tạo file với số ngẫu nhiên
    public static void createRandomNumbersFile(String filename, int count) throws IOException {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < count; i++) {
                writer.write(random.nextInt() + "\n");
            }
        }
        System.out.println("File " + filename + " has been created with " + count + " random numbers.");
    }

    // Phần b: Sao chép file và đo thời gian sao chép
    public static void copyFileWithTime(String sourceFilename, String targetFilename) throws IOException {
        Instant start = Instant.now();

        Path sourcePath = Paths.get(sourceFilename);
        Path targetPath = Paths.get(targetFilename);

        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("File " + sourceFilename + " has been copied to " + targetFilename + ".");
        System.out.println("Việc sao chép tệp thành công với thời gian: " + timeElapsed.toMillis() + " giây");
    }
}
