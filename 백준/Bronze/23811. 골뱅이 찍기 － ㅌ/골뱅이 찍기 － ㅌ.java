import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                sb.append("@".repeat(n));

                if (i % 2 == 0) {
                    sb.append("@".repeat(n * 4));
                }
                
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}