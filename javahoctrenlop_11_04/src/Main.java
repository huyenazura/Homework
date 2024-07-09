import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<List<Order>> oderSupplier = () -> {
            List<Order> danhsachorder= new ArrayList();
            for(int i=0; i<10; i++){
               Order o = new Order();
               o.madonhang="order-"+new Random().nextInt(100);
               o.makhachhang=new Random().nextInt(400);
               o.sotien=(float)(new Random().nextDouble();
               danhsachorder.add(o);
            }
            Return danhsachOrder;
        };
        List<Order> ListOrder = oderSupplier.get();
        Stream<Order> stream=ListOrder.stream();
        stream.forEach(order->{
            System.out.println("MKH")+Order.makh;
            System.out.println("MKH")+Order.madh;
            System.out.println("MKH")+Order.;

        })


    }
}
class Order{
    String madonhang;
    String makhachhang;
    double sotien;
}
//class Student{
//    Optional<String> name;
//    int agr;
//
//    public Student(String name, int agr) {
//        this.name = Optional.ofNullable(name);
//        this.agr = agr;
//    }
//
////     String getName() {
////        return name;
////    }
//
//     int getAgr() {
//        return agr;
//    }
//}