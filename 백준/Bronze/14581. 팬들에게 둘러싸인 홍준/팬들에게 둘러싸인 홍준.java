import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String name = br.readLine();
        
        for (int i = 0; i < 9; i++) {
            if (i == 4) {
                sb.append(":").append(name).append(":");
            } else {
                sb.append(":fan:");
            }
            
            if (i % 3 == 2) {
                sb.append("\n");
            }
        }
        
        System.out.println(sb.toString());
    }
}