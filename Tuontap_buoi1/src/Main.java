import javax.naming.BinaryRefAddr;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Supplier<List<Order>> supplier=()-> {
            List<Order> list=new ArrayList<>();
            for (int i=1;i<=10;i++){
                Order o= new Order();
                o.madonhang="madonhang: "+new Random().nextInt(100);
                o.makhachhang="makhachhang: "+new Random().nextInt(400);
                o.sotien=(float)(new Random().nextDouble()*400);
                list.add(o);
            }
            return list;
        };
        List<Order> listorder=supplier.get();
        Stream<Order> stream=listorder.stream();
        stream.forEach(order -> {
            System.out.println(order.madonhang);
            System.out.println(order.makhachhang);
            System.out.println(order.sotien);

        });
        Function<Order, Order> tinhthue=order -> {
            order.sotien*=1.1;
            return order;
        };
        listorder = listorder.stream()
                .map(tinhthue)
                .collect(Collectors.toList());
        System.out.println(" ");
        listorder.forEach(order -> {
            System.out.println(order.madonhang);
            System.out.println(order.makhachhang);
            System.out.println(order.sotien);
        });
        System.out.println();
        Predicate<Order> giatrilonhon100=order -> order.sotien>100;
        listorder.stream()
                .filter(giatrilonhon100)
                .forEach(order -> {
                    System.out.println(order.madonhang);
                    System.out.println(order.makhachhang);
                    System.out.println(order.sotien);
                });
        BinaryOperator<Float> tinhtong = (a1,a2) -> a1 + a2;
        float tongTien = listorder.stream()
                .map(order -> order.sotien)
                .reduce(0f, tinhtong);

        // In tổng số tiền ra màn hình
        System.out.println("Tổng số tiền của tất cả đơn hàng: " + tongTien);



    }
}
