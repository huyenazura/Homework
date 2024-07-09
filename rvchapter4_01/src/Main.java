import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {
    public static void main(String[] args) {
        try{
            writeToFile();
        } catch(Exception e){
            e.printStackTrace();
        }


    }
    public static void writeToFile() throws IOException {
        BufferedWriter bw= new BufferedWriter( new FileWriter("báo cáo làm việc với PT phát triển bản thân.docx"));
        bw.write("Test");
        bw.close();
    }
}
