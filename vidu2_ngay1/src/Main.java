import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Map<Integer,String> products =new HashMap<>();
//        products.put(1000,"Sach");
//        products.put(1000,"But");
//        System.out.println(products);
//        System.out.println(products.get(1000));
//        products.remove(1000);
//        System.out.println(products.get(1000));
//
//        products.putIfAbsent(3000, "Dien Thoai");
//        System.out.println(products.get(3000));
        Map<String, String> friendPhones = Map.of(
                "Bob", "+1-202-555-0118",
                "James", "+1-202-555-0220",
                "Katy", "+1-202-555-0175"
        );
        for (String name : friendPhones.keySet()) {
            System.out.println(name);

        }
    }
}