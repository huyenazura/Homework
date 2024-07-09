import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Tạo và khởi chạy Thread 1
        Thread thread1 = new Thread(new TimeDisplayTask());
        thread1.start();

        // Tạo và khởi chạy Thread 2
        Thread thread2 = new Thread(new RandomNumberTask());
        thread2.start();
    }
}

// Thread 1: Hiển thị giờ hiện tại sau mỗi 1 giây
class TimeDisplayTask implements Runnable {
    @Override
    public void run() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        while (true) {
            LocalTime currentTime = LocalTime.now();
            System.out.println("Thread1: " + currentTime.format(formatter));
            try {
                Thread.sleep(1000); // Tạm dừng 1 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Thread 2: Hiển thị một số ngẫu nhiên từ 1 đến 100 rồi kết thúc
class RandomNumberTask implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // Số ngẫu nhiên từ 1 đến 100
        System.out.println("Thread2: " + randomNumber);
    }
}
