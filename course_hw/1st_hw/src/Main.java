import java.util.*;
public class Main {
    public Main(){};

    Scanner sc = new Scanner(System.in);
    String[] size = new String[]{"B", "KB", "MB" , "GB", "TB"};

    public void sizeForHuman(){
        float bytes = sc.nextFloat();
        for (String elem : size) {
            if (bytes / 1024 < 1) {
                System.out.print(String.format("%.1f", bytes) + " " +  elem);
                break;
            }
            else{
                bytes /= 1024;
            }
        }
    }
    public static void main(String arg[]) {
        Main general = new Main();
        general.sizeForHuman();
    }
}
