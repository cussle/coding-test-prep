import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        for (int i = n; i > 0; i--) {
            sb.append(" ".repeat(n - i)).append("*".repeat(i)).append("\n");
        }

        System.out.println(sb.toString());
    }
}