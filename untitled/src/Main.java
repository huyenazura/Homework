public abstract class Product {
    private String name;
    protected float price;
    private String description;
    protected int quantity;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public abstract void showInfo();

    public Product(String name, float price,String description, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

}
//câub
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
//câu c
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Milk milk1=new Milk("Fresh Milk", 2.5f,"500ml",10, LocalDate.of(2024,5,1));
        Milk milk2=new Milk("Bavi Milk", 2.0f,"450m",20,LocalDate.of(2023,12,31));
        milk1.showInfo();
        milk1.checkExpired();
        System.out.println("---");
        milk2.showInfo();
        milk2.checkExpired();
    }
}
