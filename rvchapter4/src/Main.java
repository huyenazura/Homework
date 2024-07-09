import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str;
        double number;
        double total;
        double avg;
        int count;
        total = 0;
        count = 0;
        System.out.println("Nhap so cua ban, nhan quay lai de ket thuc");
        while (true){
            str= new Scanner(System.in).next();
            if(str.equals("")){
                break;
            }
            try {
                number = Double.parseDouble(str);
                total=total+number;
                count=count+1;
            }
            catch(NumberFormatException e){
                System.out.println("So khong hop le hay thu lai");
            }

        }
        avg=total/count;
        System.out.println(count);
        System.out.println(avg);
    }
}