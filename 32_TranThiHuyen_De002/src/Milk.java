import java.time.LocalDate;

public class Milk extends Product {
    private LocalDate expirationDate;  // Ngày hết hạn của sản phẩm

    // Constructor với đầy đủ các thuộc tính
    public Milk(String name, float price,String description, int quantity, LocalDate expirationDate) {
        super(name, price, description, quantity);
        this.expirationDate = expirationDate;
    }

    // Getter cho expirationDate
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    // Setter cho expirationDate
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Phương thức trừu tượng showInfo
    @Override
    public void showInfo() {
        System.out.println("Product Infomation:");
        System.out.println("Name: " + getName());
        System.out.println("Price: " + price);
        System.out.println("Description: " + getDescription());
        System.out.println("Quantity: " + quantity);
        System.out.println("Expiration Date: " + getExpirationDate());

    }

    // Phương thức trừu tượng checkExpired để kiểm tra sản phẩm đã hết hạn hay chưa
    public void checkExpired() {
        LocalDate currentDate = LocalDate.now();
        if (expirationDate.isBefore(currentDate)) {
            System.out.println("The product " + getName() + " has expired.");
        } else {
            System.out.println("The product " + getName() + " is still good.");
        }
    }
}